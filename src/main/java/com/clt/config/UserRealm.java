package com.clt.config;

import com.clt.entity.User;
import com.clt.service.UserService;
import com.google.common.io.ByteSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import sun.net.www.protocol.http.AuthenticationInfo;

import javax.security.auth.Subject;

/**
 * @author ：clt
 * @Date ：Created in 19:22 2020/02/25
 */
public class UserRealm {


}
