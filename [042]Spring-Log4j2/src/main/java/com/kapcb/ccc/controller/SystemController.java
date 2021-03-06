package com.kapcb.ccc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <a>Title: SystemController </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/7-16:41
 */
@Controller
public class SystemController {

    private static final Logger log = LoggerFactory.getLogger(SystemController.class);

    @Value(value = "#{propertiesReader['kapcb.awesome.man']}")
    private String kapcb1;

    @Value(value = "#{propertiesReader['system.kapcb.nb']}")
    private String system1;

    @Value("${kapcb.awesome.man}")
    private String kapcb;

    @Value("${system.kapcb.nb}")
    private String system;

    @GetMapping(value = "/", produces = "application/json;charset=utf-8")
    public String execute(Model model) {
        log.info("come into the index page");
        log.info("====================={}========================", "@Value(\"#{propertiesReader['xxx.xxx.xxx']})\")");
        log.info("the kapcb from kapcb properties is : {} ", kapcb1);
        log.info("the system from system properties is : {}", system1);
        log.info("====================={}========================", "@Value(\"${xxx.xxx.xxx}\")");
        log.info("the kapcb from kapcb properties is : {} ", kapcb);
        log.info("the system from system properties is : {}", system);
        model.addAttribute("kapcb", kapcb);
        model.addAttribute("system", system);
        return "index";
    }

    @ResponseBody
    @GetMapping(value = "/exception", produces = "application/json;charset=utf-8")
    public String systemHandler() {
        log.info("test the controller overall situation advance exception handler");
        throw new RuntimeException("your error, please check yourself! Thanks!");
    }
}
