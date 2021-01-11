package com.kapcb.ccc.controller;

import com.kapcb.ccc.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotNull;

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
        if (StringUtils.isNotBlank(username) || StringUtils.isBlank(password)) {
            return "username or password is null";
        }
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.login(usernamePasswordToken);
            return "login success";
        } catch (Exception e) {
            Throwable cause = e.getCause();
            if (cause instanceof IncorrectCredentialsException) {
                log.error("username or password error, the exception is : " + e.getMessage());
                return "username or password error";
            }
        }
        return "login fail";
    }
}
