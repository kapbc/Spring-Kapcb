package com.kapcb.ccc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * @date 2021/2/14 14:58
 */
@Controller
@RequestMapping(path = "/")
public class SystemController {

    private static final Logger log = LoggerFactory.getLogger(SystemController.class);

    @GetMapping
    public String index() {
        log.warn("begin to access index page...");
        return "index";
    }

    @GetMapping(value = "test")
    public String test() {
        log.warn("begin to access test page...");
        return "test/testMvcParamsController";
    }
}
