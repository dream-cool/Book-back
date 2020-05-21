package com.clt.auth;

import com.alibaba.fastjson.JSONObject;
import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.exception.AuthException;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.model.AuthResponse;
import me.zhyd.oauth.model.AuthToken;
import me.zhyd.oauth.request.*;
import me.zhyd.oauth.utils.AuthStateUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0
 * @website https://www.zhyd.me
 * @date 2019/2/19 9:28
 * @since 1.8
 */
@RestController
@RequestMapping("/oauth")
public class RestAuthController {

    @RequestMapping("/render/{source}")
    public String renderAuth(@PathVariable("source") String source, HttpServletResponse response) throws IOException {
        System.out.println("进入render：" + source);
        AuthRequest authRequest = getAuthRequest(source);
        String authorizeUrl = authRequest.authorize(AuthStateUtils.createState());
        System.out.println(authorizeUrl);
        return authorizeUrl;
    }

    /**
     * oauth平台中配置的授权回调地址，以本项目为例，在创建github授权应用时的回调地址应为：http://127.0.0.1:8443/oauth/callback/github
     */
    @RequestMapping("/callback/{source}")
    public Object login(@PathVariable("source") String source, AuthCallback callback) {
        System.out.println("进入callback：" + source + " callback params：" + JSONObject.toJSONString(callback));
        AuthRequest authRequest = getAuthRequest(source);
        AuthResponse response = authRequest.login(callback);
        System.out.println(JSONObject.toJSONString(response));
        return response;
    }

    @RequestMapping("/revoke/{source}/{token}")
    public Object revokeAuth(@PathVariable("source") String source, @PathVariable("token") String token) throws IOException {
        AuthRequest authRequest = getAuthRequest(source);
        return authRequest.revoke(AuthToken.builder().accessToken(token).build());
    }

    @RequestMapping("/refresh/{source}")
    public Object refreshAuth(@PathVariable("source") String source, String token){
        AuthRequest authRequest = getAuthRequest(source);
        return authRequest.refresh(AuthToken.builder().refreshToken(token).build());
    }

    /**
     * 根据具体的授权来源，获取授权请求工具类
     *
     * @param source
     * @return
     */
    private AuthRequest getAuthRequest(String source) {
        AuthRequest authRequest = null;
        switch (source) {
            case "github":
                authRequest = new AuthGithubRequest(AuthConfig.builder()
                        .clientId("d9f2a24577cd792329fb")
                        .clientSecret("4771a899a70baf196ce57dfeabdac90b9e3ce376")
                        .redirectUri("http://127.0.0.1:8080/oauth/callback/github")
                        .build());
                break;
            case "gitee":
                authRequest = new AuthGiteeRequest(AuthConfig.builder()
                        .clientId("6907926915fc09f18b77c3a032fc949098c4b8c25ea8a4a9d49d9f105e8d38c5")
                        .clientSecret("16503c7c15dba28b31bece45cd2cffe561fb651535e2b565c8c705f373bce1e0")
                        .redirectUri("http://127.0.0.1:8080/oauth/callback/gitee")
                        .build());
                break;
            case "qq":
                authRequest = new AuthQqRequest(AuthConfig.builder()
                        .clientId("")
                        .clientSecret("")
                        .redirectUri("http://127.0.0.1:8443/oauth/callback/qq")
                        .build());
                break;
            case "csdn":
                authRequest = new AuthCsdnRequest(AuthConfig.builder()
                        .clientId("")
                        .clientSecret("")
                        .redirectUri("http://127.0.0.1:8443/oauth/callback/csdn")
                        .build());
                break;
            default:
                break;
        }
        if (null == authRequest) {
            throw new AuthException("未获取到有效的Auth配置");
        }
        return authRequest;
    }
}