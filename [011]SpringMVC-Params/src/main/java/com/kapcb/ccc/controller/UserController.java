package com.kapcb.ccc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <a>Title:UserController</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/8 16:06
 */
@Controller
@RequestMapping("user")
public class UserController {

    /**
     * 获取请求体的数据
     *
     * @param user user
     */
    @RequestMapping(value = "testJson")
    public void testJson(@RequestBody String user) {
        System.out.println(user);
    }

}
