package com.clt.config;

import com.clt.annotation.Log;
import com.clt.dao.UserDao;
import com.clt.dao.WebLogDao;
import com.clt.entity.WebLog;
import com.clt.utils.JwtTokenUtil;
import com.clt.utils.UUIDUtil;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author ：clt
 * @Date ：Created in 18:53 2020/04/16
 */
@Aspect
@Component
public class LogAspect {

    @Resource
    private WebLogDao logDao;

    @Resource
    private UserDao userDao;

    @Resource
    private HttpServletRequest request;

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

    private void insertLog(ProceedingJoinPoint joinPoint, long time) {
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
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        webLog.setMethod(className + "." + methodName + "()");
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
        webLog.setUrl(request.getRequestURL().toString());
        final String token = request.getHeader("token");
        if (token != null && !StringUtils.isEmpty(token) && JwtTokenUtil.validateToken(token, userDao)) {
            webLog.setUserName(JwtTokenUtil.getUserNameFromToken(token));
        }
        webLog.setStartTime(new Date());
        webLog.setSpendTime(time);
        logDao.insert(webLog);
    }
}
