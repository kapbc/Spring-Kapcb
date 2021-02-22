package com.kapcb.ccc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <a>Title: SpringMvcTestController </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/21 22:41
 */
@Controller
@RequestMapping(path = "SpringMVC")
public class SpringMvcTestController {

    private static final Logger log = LoggerFactory.getLogger(SpringMvcTestController.class);

    private static final String COMMON_VIEW_NAME = "success";

    /**
     * RequestParam 测试
     *
     * @param age      Integer
     * @param username String
     * @param password String
     * @return String
     */
    @GetMapping(path = "userRequestParam")
    public String userRequestParamTest(@RequestParam(name = "age", required = false) Integer age,
                                       @RequestParam(value = "username") String username,
                                       @RequestParam("password") String password) {
        log.info("=================================");
        log.info("come into user request param...");
        log.info("the username is : {}", username);
        log.info("the password is : " + password);
        log.info("the age is : " + age);
        log.info("=================================");
        return COMMON_VIEW_NAME;
    }


}
