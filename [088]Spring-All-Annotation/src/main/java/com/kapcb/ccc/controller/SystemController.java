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
 * @date 2021/2/21 13:29
 */
@Controller
@RequestMapping(path = "/")
public class SystemController {

    private static final Logger log = LoggerFactory.getLogger(SystemController.class);
    private static final String COMMONS_LOG = "begin to access {} page...";
    private static final String VIEW_NAME_INDEX = "index";

    @GetMapping
    public String index() {
        log.warn(COMMONS_LOG, VIEW_NAME_INDEX);
        return VIEW_NAME_INDEX;
    }
}
