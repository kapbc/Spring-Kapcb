package com.kapcb.ccc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <a>Title: SystemController </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/14 14:58
 */
@Controller
@RequestMapping(path = "/")
public class SystemController {

    private static final Logger log = LoggerFactory.getLogger(SystemController.class);
    private static final String VIEW_NAME_FOR_INDEX = "index";
    private static final String VIEW_NAME_FOR_MVC_PARAMS = "test/testMvcParamsController";
    private static final String VIEW_NAME_FOR_OBJECT_BEAN = "test/testObjectBeanController";
    private static final String VIEW_NAME_FOR_MODEL_AND_VIEW = "test/testModelAndViewController";

    @GetMapping
    public String index() {
        log.warn("begin to access index page...");
        return VIEW_NAME_FOR_INDEX;
    }

    @GetMapping(value = "testMvcParams")
    public String testMvcParams() {
        log.warn("begin to access test mvc params page...");
        return VIEW_NAME_FOR_MVC_PARAMS;
    }

    @GetMapping(value = "testObjectBean")
    public String testObjectBean() {
        log.warn("begin to access test object bean page...");
        return VIEW_NAME_FOR_OBJECT_BEAN;
    }

    @GetMapping(path = "testModelAndView")
    public String testModelAndView() {
        log.warn("begin to access test model and view page...");
        return VIEW_NAME_FOR_MODEL_AND_VIEW;
    }
}
