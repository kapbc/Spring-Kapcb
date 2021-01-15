package com.kapcb.ccc.controller;

import com.kapcb.ccc.common.bean.Result;
import com.kapcb.ccc.common.constants.ResultInfo;
import com.kapcb.ccc.common.jwt.JwtUtil;
import com.kapcb.ccc.common.utils.JsonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * <a>Title: LoginController </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/16 0:06
 */
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/kapcb/shiro")
public class LoginController {

    @ResponseBody
    @PostMapping(path = "/login", produces = "application/json; charset=UTF-8")
    public String login(@RequestParam(value = "username", required = true) String username,
                        @RequestParam(value = "password", required = true) String password,
                        HttpServletResponse response) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
            log.warn("login success");
            /**
             * 登录成功后签发 token
             */
            String jwtToken = JwtUtil.sign(username, JwtUtil.CONFIDENTIAL);
            /**
             * 签发的 JWT token 设置到 HttpServletResponse 的 Header 中
             */
            response.setHeader(JwtUtil.AUTH_HEADER, jwtToken);
            return JsonUtil.convertObjectToJsonString(new Result<>(ResultInfo.SUCCESS));
        } catch (UnknownAccountException e) {
            log.error("The Login Account Is Not Exist", e);
            return JsonUtil.convertObjectToJsonString(new Result<>(ResultInfo.LOGIN_ERROR));
        } catch (IncorrectCredentialsException e) {
            log.error("The Login Account Username Or Password error, the exception is : " + e.getMessage(), e);
            return JsonUtil.convertObjectToJsonString(new Result<>(ResultInfo.LOGIN_ERROR));
        } catch (LockedAccountException e) {
            log.error("The Login Account is Locked, the exception is : " + e.getMessage(), e);
            return JsonUtil.convertObjectToJsonString(new Result<>(ResultInfo.LOGIN_LOCKED));
        } catch (AuthenticationException e) {
            log.error("The Login Account is Login exception, the exception is : " + e.getMessage(), e);
            return JsonUtil.convertObjectToJsonString(new Result<>(ResultInfo.LOGIN_EXCEPTION));
        }
    }

    @ResponseBody
    @GetMapping(path = "/logout", produces = "application/json; charset=UTF-8")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout();
            return JsonUtil.convertObjectToJsonString(new Result<>(ResultInfo.SUCCESS));
        }
        return JsonUtil.convertObjectToJsonString(new Result<>(ResultInfo.FAIL));
    }
}
