package com.kapcb.ccc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 * <a>Title: SessionAttributeController </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/21 22:41
 */
@Controller
@RequestMapping(path = "sessionAttribute")
@SessionAttributes(value = {"username", "password"}, types = Integer.class)
public class SessionAttributeController {

    private static final Logger log = LoggerFactory.getLogger(SessionAttributeController.class);

    private static final String COMMON_VIEW_NAME = "success";

    /**
     * 把数据存入 SessionAttribute
     * Model 是 spring 提供的一个接口，该接口有一个实现类 ExtendedModelMap
     * 该类继承了 ModelMap，而 ModelMap 就是 LinkedHashMap 子类
     *
     * @param model Model
     * @return String
     */
    @GetMapping(path = "testPut")
    public String testPut(Model model) {
        log.info("begin ro process test put...");
        model.addAttribute("username", "kapcb");
        model.addAttribute("password", "123456");
        /**
         * 跳转之前将数据保存到 username、 password 中，因为注解@SessionAttribute 中有username和password
         */
        return COMMON_VIEW_NAME;
    }

    /**
     * 取出 Session 中的值
     *
     * @param modelMap ModelMap ==》 LinkedHashMap
     * @return String
     */
    @GetMapping(value = "testGet")
    public String testGet(ModelMap modelMap) {
        log.info("begin to process test get...");
        String username = modelMap.get("username").toString();
        log.info("the username from ModelMap is : " + username);
        String password = modelMap.get("password").toString();
        log.info("the password from ModelMap is : " + password);
        log.info("=======================================");
        System.out.println("the username is : " + username + " the password is : " + password);
        log.info("=======================================");
        return COMMON_VIEW_NAME;
    }

    /**
     * 清除 Session 中的值
     *
     * @param sessionStatus SessionStatus
     * @return String
     */
    @GetMapping("testClean")
    public String testClean(SessionStatus sessionStatus) {
        log.info("begin to process test clean...");
        sessionStatus.setComplete();
        return COMMON_VIEW_NAME;
    }
}
