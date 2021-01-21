package com.kapcb.ccc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <a>Title: SystemController </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/20 22:42
 */
@Slf4j
@Controller
@RequestMapping(path = "/kapcb/sys")
public class SystemController {

    @GetMapping(path = "/login")
    public String toLoginPage() {
        log.warn("begin to login page");
        return "login";
    }

    @GetMapping(path = "/success")
    public String toSuccessPage() {
        log.warn("begin to login success page");
        return "success";
    }

    @GetMapping(path = "/fail")
    public String toFailPage() {
        log.warn("begin to login fail page");
        return "loginFail";
    }
}
