package com.kapcb.ccc.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <a>Title: SystemController </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/12 22:49
 */
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/kapcb/shiro")
public class SystemController {

    @RequestMapping(path = "/v2/page")
    public String toLoginPage() {
        log.warn("come to login page");
        return "login";
    }

}
