package com.kapcb.ccc.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <a>Title: UserController </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/10 10:10
 */
@Slf4j
@Controller
public class UserController {

    @Value(value = "#{propertiesReader['kapcb.kapcb.nb']}")
    private String kapcb;

    @Value(value = "#{propertiesReader['system.kapcb.nb']}")
    private String systemKapcb;

    @Value(value = "${system.kapcb.exception}")
    private String systemError;

    @GetMapping(path = "/", produces = "application/json;charset=utf-8")
    public String index() {
        log.warn("come into index page");
        return "index";
    }

    @GetMapping(path = "/exception", produces = "application/json;charset=utf-8")
    public String exception() {
        log.warn("test system controller exception advance...");
        throw new RuntimeException(systemError);
    }

    @ResponseBody
    @GetMapping(path = "/properties", produces = "application/json;charset=utf-8")
    public String properties() {
        log.warn("test properties...");
        log.warn("================{}================", "get properties by #{beanName['key']}");
        log.warn("the properties from system is : " + systemKapcb);
        log.warn("the properties from kapcb is : " + kapcb);
        log.warn("================{}================", "get properties by ${key}");
        return "the system kapcb is : " + systemKapcb + "<br />" + "the kapcb is : " + kapcb;
    }
}