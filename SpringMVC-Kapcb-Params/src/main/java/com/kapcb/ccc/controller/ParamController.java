package com.kapcb.ccc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * <a>Title:ParamController</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/8 11:21
 */
@Controller
@RequestMapping(value = "param")
public class ParamController {

    /**
     * 请求参数绑定 基于 k-v
     *
     * @param accountId accountId
     * @return success
     */
    @RequestMapping(path = "findAccount")
    public String findAccountTest(Integer accountId) {
        System.out.println("查询了账户为:" + accountId + "的余额");
        return "success";
    }

    /**
     * String类型的参数，大小写必须严格一致
     *
     * @param id   id
     * @param name name
     * @return success
     */
    @RequestMapping(value = "findAccount2")
    public String findAccountTest2(@RequestParam("accountId") Integer id, @RequestParam("accountName") String name) {
        System.out.println("查询了id为：" + id + "用户名为：" + name + "的账户");
        return "success";
    }


    /**
     * map 携带参数输出
     *
     * @param map Map<String, Object>
     * @return success
     */
    @RequestMapping(value = "map")
    public String mapTest(Map<String, Object> map) {
        map.put("message", "你好Kapcb");
        return "success";
    }

    /**
     * interface Model携带参数输出
     *
     * @param model Model
     * @return success
     */
    @RequestMapping(value = "model")
    public String modelTest(Model model) {
        model.addAttribute("message", "你好棒");
        return "success";
    }

    /**
     * ModelMap 参数携带 LinkedHashMap
     *
     * @param modelMap ModelMap
     * @return success
     */
    @RequestMapping(value = "modelMap")
    public String modelMapTest(ModelMap modelMap) {
        modelMap.addAttribute("message", "你好强");
        return "success";
    }

}
