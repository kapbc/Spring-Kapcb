package com.kapcb.ccc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <a>Title: JsonController </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/14 15:55
 */
@Controller
@RequestMapping(value = "json")
public class JsonController {

    private static final Logger log = LoggerFactory.getLogger(JsonController.class);

    private static final String FAIL = "fail";
    private static final String SUCCESS = "success";

    /**
     * 获取请求体的数据
     * 响应Json参数请求
     *
     * @param user Json String
     * @return String
     */
    @PostMapping(path = "testJson", produces = "application/json;charset=UTF-8")
    public String testJson(@RequestBody String user) {
        log.warn("test json request body...");
        System.out.println("user = " + user);
        return SUCCESS;
    }
}
