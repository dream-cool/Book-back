package com.clt.controller;

import com.clt.annotation.Log;
import com.clt.entity.User;
import com.clt.enums.LogOperationTypeEnum;
import com.clt.service.UserService;
import com.clt.utils.JwtTokenUtil;
import com.clt.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    @GetMapping("/login")
    @Log(value = "用户登录", method = LogOperationTypeEnum.LOGIN)
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
    @GetMapping("/toLogin")
    public ResultUtil<Map<Object, Object>> toLogin(HttpServletRequest request) {
        String message = request.getAttribute("message").toString();
        if (message != null && !StringUtils.isBlank(message)){
            return ResultUtil.unauthorized(null, request.getAttribute("message").toString());
        } else {
            return ResultUtil.unauthorized(null);
        }

    }

    @ApiOperation("")
    @GetMapping("/unauthorized")
    public ResultUtil<Map<Object, Object>> unauthorized(HttpServletRequest request) {
        String message = request.getAttribute("message").toString();
        if (message != null && !StringUtils.isBlank(message)){
            return ResultUtil.unauthorized(null, request.getAttribute("message").toString());
        } else {
            return ResultUtil.unauthorized(null);
        }
    }


}
