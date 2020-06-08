package com.kapcb.ccc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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


}
