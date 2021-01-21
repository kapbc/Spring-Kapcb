package com.kapcb.ccc.controller;

import com.kapcb.ccc.commons.constants.Constant;
import com.kapcb.ccc.commons.constants.ResultInfo;
import com.kapcb.ccc.commons.domain.Result;
import com.kapcb.ccc.commons.utils.JsonUtil;
import com.kapcb.ccc.commons.utils.JwtUtil;
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
 * @date 2021/1/20 22:42
 */
@Slf4j
@Controller
@RequestMapping(path = "/kapcb")
@RequiredArgsConstructor
public class LoginController {

    @ResponseBody
    @PostMapping(path = "login", produces = "application/json; charset = UTF-8")
    public String login(@RequestParam(value = "username", required = true) String username,
                        @RequestParam(value = "password", required = true) String password,
                        HttpServletResponse responses) {
        log.warn("username is : " + username + "; password is : " + password);
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        boolean isAllowLogin = false;
        Result<Object> result = null;
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.login(usernamePasswordToken);
            log.warn("shiro process login success");
            isAllowLogin = true;
        } catch (UnknownAccountException e) {
            log.warn("the account of username : " + username + " is not exist in the system");
            result = new Result<>(ResultInfo.LOGIN_ERROR);
        } catch (IncorrectCredentialsException e) {
            log.warn("the account of username : " + username + "'s username of password is error");
            result = new Result<>(ResultInfo.LOGIN_ACCOUNT_ERROR);
        } catch (LockedAccountException e) {
            log.warn("the account of username : " + username + "'s account is locked");
            result = new Result<>(ResultInfo.LOGIN_ACCOUNT_LOCKED);
        } catch (AuthenticationException e) {
            log.warn("the account of username : " + username + " authentication error");
            result = new Result<>(ResultInfo.LOGIN_EXCEPTION);
        }
        log.warn("the flag of is allow login is : " + isAllowLogin);
        if (isAllowLogin) {
            String sign = JwtUtil.sign(username, Constant.JWT_SECRET.getString());
            responses.setHeader(Constant.JWT_AUTHORIZATION_HEARD.getString(), sign);
        }
        return JsonUtil.convertToJsonString(result);
    }

    @ResponseBody
    @GetMapping(path = "/logout", produces = "appllication/json; charset=UTF-8")
    public String logout() {
        log.warn("process the logout");
        Result<Object> result = new Result<>(ResultInfo.UN_LOGIN_LOGOUT);
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            log.warn("is already login to request the logout");
            subject.logout();
            result = new Result<>(ResultInfo.LOGOUT_SUCCESS);
        }
        return JsonUtil.convertToJsonString(result);
    }
}
