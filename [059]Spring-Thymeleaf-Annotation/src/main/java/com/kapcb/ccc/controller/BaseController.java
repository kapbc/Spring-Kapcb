package com.kapcb.ccc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <a>Title: BaseController </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/29 22:42
 */
@Slf4j
@Controller
@RequestMapping
public class BaseController {

    @GetMapping(path = "/")
    public String base() {
        log.warn("come into index page...");
        return "index";
    }
}
