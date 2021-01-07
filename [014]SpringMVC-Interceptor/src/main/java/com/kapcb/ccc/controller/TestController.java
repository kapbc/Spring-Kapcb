package com.kapcb.ccc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <a>Title:TestController</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/8 20:13
 */
@Controller
@RequestMapping(value = "test")
public class TestController {

    /**
     * 测试用拦截器进行拦截的方法
     *
     * @return success
     */
    @RequestMapping(value = "test01", method = RequestMethod.GET)
    public String test01() {
        System.out.println("test01方法执行");
        return "success";
    }

    /**
     * 测试未用拦截器拦截的方法
     *
     * @return success
     */
    @RequestMapping(value = "test02", method = RequestMethod.GET)
    public String test02() {
        System.out.println("test02方法执行了");
        return "success";
    }
}
