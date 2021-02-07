package com.kapcb.ccc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <a>Title: SystemController </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/7-9:35
 */
@Controller
public class SystemController {

    private static final Logger log = LoggerFactory.getLogger(SystemController.class);

    @Value(value = "#{propertiesReader['kapcb.properties.awesome']}")
    private String kapcbNb;

    @Value(value = "#{propertiesReader['system.properties.author']}")
    private String kapcb;

//    @Value(value = "${kapcb.properties.awesome}")
//    private String nb;
//
//    @Value(value = "${system.properties.author}")
//    private String awesome;


    @GetMapping("/")
    public String index() {
        log.warn("come into index page");
        System.out.println("===============test properties================");
        System.out.println("kapcbNb = " + kapcbNb);
        System.out.println("kapcb = " + kapcb);
//        System.out.println("nb = " + nb);
//        System.out.println("awesome = " + awesome);
        System.out.println("===============test properties================");
        throw new RuntimeException("system error");

//        CgLibAutoDynamicProxy cgLibAutoDynamicProxy = new CgLibAutoDynamicProxy();
//        User user = (User) cgLibAutoDynamicProxy.CreateProxyObject(User.class);
//        System.out.println("user = " + user);
//        System.out.println("user.getClass() = " + user.getClass());
//        return "index";
    }
}
