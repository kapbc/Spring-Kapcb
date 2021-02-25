package com.kapcb.ccc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <a>Title: InterceptorController </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/24 22:48
 */
@Controller
@RequestMapping(path = "test")
public class InterceptorController {

    private static final Logger log = LoggerFactory.getLogger(InterceptorController.class);

    private static final String SUCCESS_VIEW_NAME = "/view/success";

    /**
     * test with interceptor
     *
     * @return String
     */
    @GetMapping(path = "testWithInterceptor")
    public String testInterceptor() {
        log.info("come into test with interceptor...");
        return SUCCESS_VIEW_NAME;
    }

    /**
     * test without interceptor
     *
     * @return
     */
    @GetMapping(value = "testWithoutInterceptor")
    public String testWithoutInterceptor() {
        log.info("come into test without interceptor...");
        return SUCCESS_VIEW_NAME;
    }
}
