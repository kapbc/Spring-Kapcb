package com.kapcb.ccc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    /**
     * RequestBody 测试
     * 接受 json 参数
     *
     * @param user String
     * @return String
     */
    @PostMapping(value = "userRequestBody")
    public String userRequestBodyTest(@RequestBody String user) {
        log.info("come into user request body...");
        log.info("the request body user is : " + user);
        return COMMON_VIEW_NAME;
    }

    /**
     * PathVariable 测试
     * 路径参数测试
     *
     * @param id String
     * @return String
     */
    @PostMapping(value = "userPathVariable/{id}")
    public String userPathVariableTest(@PathVariable(value = "id") String id) {
        log.info("come into user path variable...");
        log.info("the path variable is : " + id);
        return COMMON_VIEW_NAME;
    }

    /**
     * PathVariable 测试
     * 路径参数测试
     *
     * @param id       String
     * @param username String
     * @return String
     */
    @PostMapping(value = "userPathVariable/{id}/{username}")
    public String userPathVariableTest(@PathVariable("id") String id,
                                       @PathVariable(name = "username") String username) {
        log.info("come into user path variable...");
        log.info("the path variable's id is : " + id);
        log.info("the path variable's username is : " + username);
        return COMMON_VIEW_NAME;
    }

    /**
     * PathVariable 测试
     * 路径参数测试
     *
     * @param id       String
     * @param username String
     * @param password String
     * @return String
     */
    @PostMapping(value = "userPathVariable/{id}/{username}/{password}")
    public String userPathVariableTest(@PathVariable("id") String id,
                                       @PathVariable(name = "username") String username,
                                       @PathVariable(value = "password") String password) {
        log.info("come into user path variable...");
        log.info("the path variable's id is : " + id);
        log.info("the path variable's username is : " + username);
        log.info("the path variable's password is : " + password);
        return COMMON_VIEW_NAME;
    }


}