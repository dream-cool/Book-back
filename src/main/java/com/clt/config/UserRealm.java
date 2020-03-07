package com.clt.config;

import com.clt.entity.Permission;
import com.clt.entity.User;
import com.clt.enums.UserEnum;
import com.clt.service.PermissionService;
import com.clt.service.UserService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：clt
 * @Date ：Created in 19:22 2020/02/25
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    /**
     * 执行授权逻辑
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        final Permission permission = permissionService.queryById(user.getUserId());
        info.addStringPermission(permission.toString());
        System.out.println(user);
        return info;
    }

    /**
     * 执行认证逻辑
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = new User();
        user.setUserName(token.getUsername());
        final List<User> users = userService.queryAllByCondition(user);
        for (User userResult : users) {
            if (userResult == null){
                return null;
            } else {
                if (UserEnum.USER_STATUS_LOCKED.getCode().equals(user.getStatus())){
                    throw new LockedAccountException();
                }
            }
            final Permission userPermission = permissionService.queryById(userResult.getUserId());
            userResult.setPermission(userPermission);
            ByteSource salt = ByteSource.Util.bytes(userResult.getUserName());
            return new SimpleAuthenticationInfo(userResult,userResult.getPassword(),salt,"userRealm");
        }
        return null;
    }


}
