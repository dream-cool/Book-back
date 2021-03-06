package com.clt.config;

import com.clt.annotation.Log;
import com.clt.dao.UserDao;
import com.clt.dao.WebLogDao;
import com.clt.entity.WebLog;
import com.clt.enums.LogOperationTypeEnum;
import com.clt.utils.HttpUtil;
import com.clt.utils.JwtTokenUtil;
import com.clt.utils.UUIDUtil;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：clt
 * @Date ：Created in 18:53 2020/04/16
 */
@Aspect
@Component
public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Resource
    private WebLogDao logDao;

    @Resource
    private UserDao userDao;

    @Resource
    private HttpServletRequest request;

    private List<WebLog> logList = new ArrayList<>(100);

    private ReentrantLock lock = new ReentrantLock();

    private AtomicLong index = new AtomicLong(0);

    @Pointcut("@annotation(com.clt.annotation.Log)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) {
        Object result = null;
        long beginTime = System.currentTimeMillis();
        try {
            // 执行方法
            result = point.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        // 执行时长(毫秒)
        long spendTime = System.currentTimeMillis() - beginTime;
        // 保存日志
        insertLog(point, spendTime);
        return result;
    }

    @Async
    void insertLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        WebLog webLog = new WebLog();
        Log logAnnotation = method.getAnnotation(Log.class);
        if (logAnnotation != null) {
            // 注解上的描述
            webLog.setOperation(logAnnotation.value());
            webLog.setType(logAnnotation.method().getMessage());
        }
        // 请求的方法名
        String classFullName = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        final String[] classNames = classFullName.split("\\.");
        webLog.setMethod(classNames[classNames.length - 1] + "." + methodName + "()");
        // 请求的方法参数值
        Object[] args = joinPoint.getArgs();
        // 请求的方法参数名称
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(method);
        if (args != null && paramNames != null) {
            String params = "";
            for (int i = 0; i < args.length; i++) {
                params += "  " + paramNames[i] + ": " + args[i];
            }
            webLog.setParameter(params);
        }
        webLog.setId(UUIDUtil.getUUID());
        webLog.setIp(request.getRemoteAddr());
        if (webLog.getIp() != null && !StringUtils.isBlank(webLog.getIp())) {
            String result = HttpUtil.sendGet("http://whois.pconline.com.cn/jsFunction.jsp?ip=" + webLog.getIp());
            if (result == null || StringUtils.isBlank(result)) {
                webLog.setAddr("未知");
            } else {
                int start = result.indexOf('\'');
                int end = result.indexOf('\'', start + 1);
                webLog.setAddr(result.substring(start + 1, end));
            }
        }
        webLog.setUrl(request.getRequestURI());
        webLog.setStartTime(new Date());
        webLog.setSpendTime(time);
        final String token = request.getHeader("token");
        if (token != null && !StringUtils.isEmpty(token) && JwtTokenUtil.validateToken(token, userDao)) {
            webLog.setUserName(JwtTokenUtil.getUserNameFromToken(token));
        } else {
            if (logAnnotation.method().equals(LogOperationTypeEnum.LOGIN)) {
                webLog.setUserName(args[0].toString());
            }
        }
        handleLogInsert(webLog);
//        logDao.insert(webLog);
    }

    public void handleLogInsert(WebLog webLog){
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            logList.add(webLog);
            if (index.incrementAndGet() % 100 == 0){
                logDao.insertBatch(logList);
//                index.set(0);
                logger.info("listSize: [{}]", logList.size());
                logList = new ArrayList<>(100);
                if (logger.isDebugEnabled()){
                    logger.debug("日志数据已被插入");
                }
                logger.info("日志数据已被插入 index:[{}], listSize: [{}]", index, logList.size());
            }
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

    }
}
