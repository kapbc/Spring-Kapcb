package com.kapcb.ccc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <a>Title: SystemController </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/14 13:37
 */
@Controller
@RequestMapping(path = "/")
public class SystemController {

    private static final Logger log = LoggerFactory.getLogger(SystemController.class);

    @GetMapping(produces = "application/json; charset=UTF-8")
    public String index(Model model) {
        log.warn("come into index page....");
        model.addAttribute("kapcb", "kapcb");
        return "index";
    }

    @ResponseBody
    @GetMapping(path = "kapcb", produces = "application/json; charset=UTF-8")
    public String helloSpringMVC() {
        log.warn("process hello spring mvc...");
        return "Hello Kapcb";
    }
}
