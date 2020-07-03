package com.kapcb.ccc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <a>Title:TestController</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/7 21:30
 */
@Controller
public class TestController {

    @RequestMapping("/hello")
    public String TestMethod() {
        System.out.println("接收到请求");
        return "success";
    }
}
