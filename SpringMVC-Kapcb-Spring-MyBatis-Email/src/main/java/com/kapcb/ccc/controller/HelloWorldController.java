package com.kapcb.ccc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <a>Title: HelloWorldController </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/23 - 19:55
 */
@Controller
public class HelloWorldController {

    @RequestMapping("/")
    public String projectIntiHandler() {
        System.out.println("The Project Init Success");
        return "email/email_template";
    }

    @RequestMapping("/hello")
    public String controllerHandler() {
        System.out.println("请求已收到");
        return "success";
    }
}
