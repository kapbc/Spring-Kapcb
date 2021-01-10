package com.kapcb.ccc.controller;

import com.kapcb.ccc.common.bean.ResultBean;
import com.kapcb.ccc.common.dto.ResultInfo;
import com.kapcb.ccc.common.exception.UserNotExistException;
import com.kapcb.ccc.common.utils.JsonUtil;
import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Objects;

/**
 * <a>Title: LoginController </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/9 17:30
 */
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/kapcb/shiro")
public class LoginController {

    private final UserService userService;

    @GetMapping(path = "/transmissionDoor")
    public String transmissionDoor() {
        log.warn("come to login page");
        return "kapcb";
    }

    @ResponseBody
    @PostMapping(path = "/test/login", produces = "application/json; charset=UTF-8")
    public String testLogin(@RequestParam(name = "username", required = true) String username,
                            @RequestParam(name = "password", required = true) String password) {
        log.warn("username is : " + username + " password is : " + password);
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            log.warn("username or password is null");
            return JsonUtil.convertObjectBeanToJsonString(null);
        }
        try {
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
            log.warn("usernamePasswordToken is : " + usernamePasswordToken);
            Subject subject = SecurityUtils.getSubject();
            subject.login(usernamePasswordToken);
            log.warn("process login success!");
            log.warn("return String result is : " + JsonUtil.convertObjectBeanToJsonString(new ResultBean<>(ResultInfo.LOGIN_SUCCESS)));
            return JsonUtil.convertObjectBeanToJsonString(new ResultBean<>(ResultInfo.LOGIN_SUCCESS));
        } catch (Exception e) {
            log.error("process login fail, the error exception is : " + e.getMessage(), e);
            Throwable cause = e.getCause();
            if (cause instanceof UserNotExistException) {
                log.error("login fail");
                return JsonUtil.convertObjectBeanToJsonString(new ResultBean<>(ResultInfo.LOGIN_FAIL));
            }
            if (cause instanceof IncorrectCredentialsException) {
                log.error("login password error");
                return JsonUtil.convertObjectBeanToJsonString(new ResultBean<>(ResultInfo.LOGIN_PASSWORD_ERROR));
            }
        }
        log.warn("login fail");
        return JsonUtil.convertObjectBeanToJsonString(null);
    }

    /**
     * http://localhost:8080/kapcb/shiro/test/logout
     *
     * @return
     */
    @ResponseBody
    @GetMapping(path = "/test/logout", produces = "application/json;charset=UTF-8")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        log.warn("subject for logout is : " + subject);
        if (subject.isAuthenticated()) {
            log.warn("I am already Login. So I can logout!");
            subject.logout();
        }
        return JsonUtil.convertObjectBeanToJsonString(new ResultBean<>(ResultInfo.LOGOUT_SUCCESS));
    }

    /**
     * http://localhost:8080/kapcb/shiro/test/getUserInfo
     *
     * @return
     */
    @ResponseBody
    @GetMapping(path = "/test/getUserInfo", produces = "application/json;charset=UTF-8")
    public String getUserInfo() {
        log.warn("process get user info");
        List<User> userInfo = userService.getUserInfo();
        return JsonUtil.convertObjectBeanToJsonString(Objects.equals(null, userInfo) ? null : new ResultBean<>(ResultInfo.SUCCESS, userInfo));
    }

}
