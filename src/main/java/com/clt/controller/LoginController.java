package com.clt.controller;

import com.clt.entity.User;
import com.clt.service.UserService;
import com.clt.utils.JwtTokenUtil;
import com.clt.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：clt
 * @Date ：Created in 21:32 2020/03/06
 */
@Api("用户实体")
@RestController
public class LoginController {

    @Autowired
    private UserService userService;


    @ApiOperation("")
    @RequestMapping("/login")
    public ResultUtil<Map<String, Object>> login(
            @ApiParam("用户名") @RequestParam("userName") String userName,
            @ApiParam("密码") @RequestParam("password") String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            return ResultUtil.failed("账号不存在");
        } catch (IncorrectCredentialsException e) {
            return ResultUtil.failed("账号或密码错误");
        } catch (LockedAccountException e) {
            return ResultUtil.failed("用户已锁定，请联系管理员");
        }
        final User userDetail = (User) subject.getPrincipal();
        userDetail.setLastLoginTime(new Date());
        userService.update(userDetail);
        Map<String, Object> data = new HashMap<>(16);
        data.put("token", JwtTokenUtil.generateToken(userDetail));
        data.put("userDetail", userDetail);
        return ResultUtil.success(data, "登录成功");
    }


    @ApiOperation("")
    @RequestMapping("/toLogin")
    public ResultUtil<Map<Object, Object>> toLogin() {
        return ResultUtil.unauthorized(null);
    }

    @ApiOperation("")
    @RequestMapping("/unauthorized")
    public ResultUtil<Map<Object, Object>> unauthorized() {
        return ResultUtil.unauthorized(null);
    }


}
