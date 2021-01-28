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
 * @date 2021/1/28 22:29
 */
@Slf4j
@Controller
@RequestMapping
public class SystemController {

    @GetMapping(path = "/")
    public String system() {
        log.warn("come into index page");
        return "index";
    }
}
