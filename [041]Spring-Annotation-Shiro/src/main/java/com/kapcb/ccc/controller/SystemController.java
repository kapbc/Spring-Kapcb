package com.kapcb.ccc.controller;

import lombok.RequiredArgsConstructor;
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
 * @date 2021/1/11 20:56
 */
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/kapcb/shiro")
public class SystemController {

    @GetMapping("/transmissionDoor")
    public String toLoginPage() {
        log.warn("come into login page");
        return "kapcb";
    }
}
