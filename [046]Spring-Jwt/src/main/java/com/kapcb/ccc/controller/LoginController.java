package com.kapcb.ccc.controller;

import com.kapcb.ccc.commons.bean.Result;
import com.kapcb.ccc.commons.bean.ResultInfo;
import com.kapcb.ccc.commons.jwt.JwtUtil;
import com.kapcb.ccc.service.IUserService;
import com.kapcb.ccc.utils.JsonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <a>Title: LoginController </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/17 22:34
 */
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/kapcb")
public class LoginController {

    private final IUserService userService;

    @ResponseBody
    @PostMapping(path = "/login", produces = "application/json;charset=UTF-8")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        log.warn("username is : " + username + "; password is : " + password);
        if (userService.getUserByUsername(username, password)) {
            // 生成token
            String token = JwtUtil.getToken("1", "Jersey-Security-Basic", username);
            log.warn("token is : " + token);
            // 向浏览器返回token，客户端受到此token后存入cookie中，或者h5的本地存储中
            return JsonUtil.convertBeanToString(new Result<>(ResultInfo.SUCCESS, token));
        }
        return JsonUtil.convertBeanToString(null);
    }
}
