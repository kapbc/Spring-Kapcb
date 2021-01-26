package com.kapcb.ccc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <a>Title: TestDrivenDevelopment </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/26 21:30
 */
@Slf4j
@Controller
@ResponseBody
@RequestMapping(path = "/test")
public class TestDrivenDevelopment {

    @GetMapping(path = "/one", produces = "application/json;charset=utf-8")
    public String test() {
        log.info("test the logback...");
        return "success";
    }
}
