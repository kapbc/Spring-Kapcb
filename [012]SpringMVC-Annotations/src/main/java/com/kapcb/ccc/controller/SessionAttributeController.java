package com.kapcb.ccc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 * <a>Title:SessionAttributeController</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/8 10:45
 */
@Controller
@RequestMapping("/sessionAttribute")
@SessionAttributes(value = {"username", "password"}, types = {Integer.class})
public class SessionAttributeController {

    /**
     * 把数据存入 SessionAttribute
     * Model 是 spring 提供的一个接口，该接口有一个实现类 ExtendedModelMap
     * 该类继承了 ModelMap，而 ModelMap 就是 LinkedHashMap 子类
     *
     * @param model model
     * @return success
     */
    @RequestMapping("testPut")
    public String testPut(Model model) {
        model.addAttribute("username", "kapcb");
        model.addAttribute("password", "123456");
        //跳转之前将数据保存到 username、 password 中，因为注解@SessionAttribute 中有
        return "success";
    }

    /**
     * 取出 session 中的值
     *
     * @param model ModelMap LinkedHashMap
     * @return success
     */
    @RequestMapping("testGet")
    public String testGet(ModelMap model) {
        System.out.println(model.get("username") + ";" + model.get("password"));
        return "success";
    }

    /**
     * 清除 session 中的值
     *
     * @param sessionStatus sessionStatus
     * @return success
     */
    @RequestMapping("testClean")
    public String testClean(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "success";
    }

}
