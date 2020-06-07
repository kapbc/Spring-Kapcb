package com.kapcb.ccc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <a>Title:MyFirstController</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/7 18:07
 */
@Controller
public class MyFirstController {

    @RequestMapping(value = "/hello")
    public String MyFirstHandler(){
        System.out.println("请求已收到");
        return "success";
    }
}
