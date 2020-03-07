package com.clt.config;

import com.clt.fitter.ShiroFilter;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;

/**
 * @author ：clt
 * @Date ：Created in 19:21 2020/02/25
 */
@Configuration
public class ShiroConfig {
    /**
     * ShiroFilterFactoryBean
     * <p>
     * Shiro内置过滤器，可以实现权限相关的拦截器
     * 常用的过滤器：
     * anon: 无需认证（登录）可以访问
     * authc: 必须认证才可以访问
     * user: 如果使用rememberMe的功能可以直接访问
     * perms：该资源必须得到资源权限才可以访问
     * role: 该资源必须得到角色权限才可以访问
     */

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        LinkedHashMap<String, Filter> shiroFilter = new LinkedHashMap<>();
        shiroFilter.put("authc", new ShiroFilter());
        shiroFilterFactoryBean.setFilters(shiroFilter);
        LinkedHashMap<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/**", "authc");
        //修改调整的登录页面
        shiroFilterFactoryBean.setLoginUrl("/toLogin");
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }

    /**
     * DefaultWebSecurityManager
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }


    /**
     * Realm
     */
    @Bean(name = "userRealm")
    public UserRealm getRealm() {
        UserRealm userRealm = new UserRealm();
        userRealm.setCachingEnabled(false);
        CredentialsMatcher matcher = new HashedCredentialsMatcher();
        ((HashedCredentialsMatcher) matcher).setHashAlgorithmName("MD5");
        ((HashedCredentialsMatcher) matcher).setHashIterations(1024);
        userRealm.setCredentialsMatcher(matcher);

        return userRealm;
    }
}
