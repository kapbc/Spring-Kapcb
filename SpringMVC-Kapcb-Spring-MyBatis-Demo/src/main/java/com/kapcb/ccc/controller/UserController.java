package com.kapcb.ccc.controller;

import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <a>Title:UserController</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/9 10:45
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(path = "testSpringMVC")
    public String testSpringMVC() {
        System.out.println("控制器收到请求");
        List<User> all = userService.findAll();
        all.stream().forEach(System.out::println);
        return "success";
    }
}
