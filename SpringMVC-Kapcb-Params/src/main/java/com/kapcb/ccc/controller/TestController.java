package com.kapcb.ccc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <a>Title:TestController</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/8 11:08
 */
@Controller
public class TestController {

    @RequestMapping("test")
    public String test(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
        return "success";
    }

}
