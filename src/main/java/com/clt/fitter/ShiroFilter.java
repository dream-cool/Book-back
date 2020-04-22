package com.clt.fitter;

import com.clt.config.IgnoreUrlsConfig;
import com.clt.dao.UserDao;
import com.clt.entity.User;
import com.clt.utils.DateUtils;
import com.clt.utils.JwtTokenUtil;
import com.clt.utils.SpringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：clt
 * @Date ：Created in 23:06 2020/03/06
 */
@WebFilter
public class ShiroFilter extends AccessControlFilter {

    Logger logger = LoggerFactory.getLogger(ShiroFilter.class);

    @Resource
    private UserDao userDao;


    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        Map<String, Object> data = new HashMap<>(16);
        HttpServletRequest req = (HttpServletRequest) request;
        if (req.getMethod().equalsIgnoreCase(RequestMethod.OPTIONS.name())) {
            return true;
        }
        String token = getRequestToken((HttpServletRequest) request);
        String url = ((HttpServletRequest) request).getServletPath();
        IgnoreUrlsConfig ignoreUrlsConfig = (IgnoreUrlsConfig) SpringUtils.getBean("ignoreUrlsConfig");
        for (String ignoreUrl : ignoreUrlsConfig.getUrls()) {
            if (url.startsWith(ignoreUrl)){
                return true;
            }
        }
        if (StringUtils.isBlank(token)) {
            logger.info("请求未携带token");
            request.setAttribute("message","请求未携带token");
            request.getRequestDispatcher("/unauthorized").forward(request, response);
            return false;
        }
        //对当前ID进行SHA256加密
        final String userNameFromToken = JwtTokenUtil.getUserNameFromToken(token);
        if (userNameFromToken == null ) {
            logger.info("无效token");
            request.setAttribute("message","无效token");
            request.getRequestDispatcher("/unauthorized").forward(request, response);
            return false;
        }
        if (JwtTokenUtil.isTokenExpired(token) ) {
            logger.info("token已过期");
            request.setAttribute("message","token已过期,请重新登陆");
            request.getRequestDispatcher("/unauthorized").forward(request, response);
            return false;
        }
        Date expiredTime = JwtTokenUtil.getExpiredDateFromToken(token);
        if (expiredTime.getTime() - System.currentTimeMillis() < DateUtils.FIVE_MINUTE){
            ((HttpServletResponse) response).addHeader("token", JwtTokenUtil.refreshToken(token));
            ((HttpServletResponse) response).addHeader("Access-Control-Expose-Headers", "token");
        }
        userDao = (UserDao) SpringUtils.getBean("userDao");
        if (JwtTokenUtil.validateToken(token,userDao)) {
            return true;
        }
        request.setAttribute("message","未知错误");
        request.getRequestDispatcher("/unauthorized").forward(request, response);
        return false;
    }

    private String getRequestToken(HttpServletRequest request) {
        //默认从请求头中获得token
        String token = request.getHeader("token");
        //如果header中不存在token，则从参数中获取token
        if (StringUtils.isBlank(token)) {
            token = request.getParameter("token");
        }
        return token;
    }
}
