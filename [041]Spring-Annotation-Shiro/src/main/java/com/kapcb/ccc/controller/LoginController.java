package com.kapcb.ccc.controller;

import com.kapcb.ccc.commons.bean.ResultInfo;
import com.kapcb.ccc.commons.dto.Result;
import com.kapcb.ccc.commons.utils.JsonUtil;
import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.service.UserService;
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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * <a>Title: LoginController </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/11 20:36
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/kapcb/shiro/v1")
public class LoginController {

    private final UserService userService;

    @ResponseBody
    @PostMapping(path = "/login", produces = "application/json; charset=UTF-8")
    public String login(@NotNull(message = "{required}") @RequestParam(name = "username", required = false) String username,
                        @NotNull(message = "{required}") @RequestParam(name = "password", required = false) String password) {
        log.warn("username is : " + username + " password is : " + password);
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.login(usernamePasswordToken);
            return JsonUtil.convertObjectBeanToJsonString(new Result<>(ResultInfo.SUCCESS));
        } catch (Exception e) {
            Throwable cause = e.getCause();
            if (cause instanceof UnknownAccountException) {
                log.error("username or password error, the exception is : " + e.getMessage());
                return JsonUtil.convertObjectBeanToJsonString(new Result<>(ResultInfo.LOGIN_ERROR));
            }
            if (cause instanceof IncorrectCredentialsException) {
                log.error("username or password error, the exception is : " + e.getMessage());
                return JsonUtil.convertObjectBeanToJsonString(new Result<>(ResultInfo.LOGIN_ERROR));
            }
            if (cause instanceof LockedAccountException) {
                log.error("account is locked, please get touch with admin, the exception is : " + e.getMessage());
                JsonUtil.convertObjectBeanToJsonString(new Result<>(ResultInfo.LOGIN_ACCOUNT_LOCKED));
            }
            if (cause instanceof AuthenticationException) {
                log.error("login error, please get touch with admin");
                return JsonUtil.convertObjectBeanToJsonString(new Result<>(ResultInfo.LOGIN_ACCOUNT_EXCEPTION));
            }
        }
        return JsonUtil.convertObjectBeanToJsonString(new Result<>(ResultInfo.FAIL));
    }

    @ResponseBody
    @GetMapping(path = "/logout", produces = "application/json; charset=UTF-8")
    public String logout() {
        log.warn("process logout");
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout();
            return JsonUtil.convertObjectBeanToJsonString(new Result<>(ResultInfo.SUCCESS));
        }
        return JsonUtil.convertObjectBeanToJsonString(new Result<>(ResultInfo.UN_LOGIN_ACCESS_LOGOUT));
    }

    @ResponseBody
    @GetMapping(path = "getUserInfo", produces = "application/json; charset=UTF-8")
    public String getUserInfo() {
        log.warn("process getUserInfo");
        List<User> userInfo = userService.getUserInfo();
        if (userInfo.size() > 0) {
            return JsonUtil.convertObjectBeanToJsonString(new Result<>(ResultInfo.SUCCESS, userInfo));
        }
        return JsonUtil.convertObjectBeanToJsonString(new Result<>(ResultInfo.FAIL));
    }
}
