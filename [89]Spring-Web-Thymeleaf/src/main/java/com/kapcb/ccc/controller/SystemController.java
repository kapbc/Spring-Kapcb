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
 * @date 2021/2/20 22:48
 */
@Controller
@RequestMapping(path = "/")
public class SystemController {

    private static final Logger log = LoggerFactory.getLogger(SystemController.class);

    private static final String RESOURCES_VIEW_INDEX = "index";
    private static final String COMMON_LOG_ROUTE = "begin to access {} page...";


    @GetMapping
    public String index() {
        log.warn(COMMON_LOG_ROUTE, RESOURCES_VIEW_INDEX);
        return RESOURCES_VIEW_INDEX;
    }
}
