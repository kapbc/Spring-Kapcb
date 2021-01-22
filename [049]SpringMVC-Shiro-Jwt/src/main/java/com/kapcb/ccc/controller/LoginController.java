package com.kapcb.ccc.controller;

import com.kapcb.ccc.commons.constant.Constants;
import com.kapcb.ccc.commons.constant.ResultInfo;
import com.kapcb.ccc.commons.domain.Result;
import com.kapcb.ccc.commons.utils.json.JsonUtil;
import com.kapcb.ccc.commons.utils.jwt.JwtUtil;
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
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/22-15:28
 */
@Slf4j
@Controller
@ResponseBody
@RequestMapping(path = "/kapcb")
public class LoginController {


    @PostMapping(path = "/login", produces = "application/json;charset=UTF-8")
    public String login(@RequestParam(value = "username", required = true) String username,
                        @RequestParam(value = "password", required = true) String password,
                        HttpServletResponse response) {
        log.info("username is : " + username + "; password is :" + password);
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        boolean loginSuccess = false;
        Result<Object> result = new Result<>(ResultInfo.FAIL);
        try {
            subject.login(usernamePasswordToken);
            log.info("process login success");
            loginSuccess = true;
        } catch (UnknownAccountException e) {
            log.error("The Login Account Is Not Exist", e);
            result = new Result<>(ResultInfo.INVALID);
        } catch (IncorrectCredentialsException e) {
            log.error("The Login Account Username Or Password error, the exception is : " + e.getMessage(), e);
            result = new Result<>(ResultInfo.INVALID);
        } catch (LockedAccountException e) {
            log.error("The Login Account is Locked, the exception is : " + e.getMessage(), e);
            result = new Result<>(ResultInfo.LOCKED);
        } catch (AuthenticationException e) {
            log.error("The Login Account is Login exception, the exception is : " + e.getMessage(), e);
            result = new Result<>(ResultInfo.EXCEPTION);
        }
        if (loginSuccess) {
            String sign = JwtUtil.sign(username, Constants.JWT_SECRET.getString());
            log.info("the access token is : " + sign);
            response.setHeader(Constants.JWT_AUTHORIZATION_HEARD.getString(), sign);
            result = new Result<>(ResultInfo.SUCCESS);
        }
        return JsonUtil.convertResultToJsonString(result);
    }

    @GetMapping(path = "logout", produces = "application/json;charset = UTF-8")
    public String logout() {
        Result<Object> result = new Result<>(ResultInfo.UN_LOGIN);
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout();
            result = new Result<>(ResultInfo.SUCCESS);
        }
        return JsonUtil.convertResultToJsonString(result);
    }
}
