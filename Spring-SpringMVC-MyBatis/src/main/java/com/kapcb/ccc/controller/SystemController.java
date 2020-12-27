package com.kapcb.ccc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <a>Title: SystemController </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/27 - 18:38
 */
@Controller
@RequestMapping("/test")
public class SystemController {

    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public String test() {
        Long id = 1L;
        System.out.println("Spring MVC initial... success...");
        return "success";
    }

}
