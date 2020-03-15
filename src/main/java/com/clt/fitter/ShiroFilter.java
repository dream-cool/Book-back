package com.clt.fitter;

import com.clt.config.IgnoreUrlsConfig;
import com.clt.dao.UserDao;
import com.clt.entity.User;
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
            logger.info("没有token");
            ((HttpServletResponse) response).sendRedirect("/unauthorized");
            return false;
        }
        //对当前ID进行SHA256加密
        final String userIdFromToken = JwtTokenUtil.getUserIdFromToken(token);
        if (userIdFromToken == null) {
            logger.info("无效token");
            ((HttpServletResponse) response).sendRedirect("/unauthorized");
            return false;
        }
        if (userDao == null) {
            userDao = (UserDao) SpringUtils.getBean("userDao");
        }
        final User user = userDao.queryById(userIdFromToken);
        if (user != null) {
            return true;
        }
        ((HttpServletResponse) response).sendRedirect("/unauthorized");
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
