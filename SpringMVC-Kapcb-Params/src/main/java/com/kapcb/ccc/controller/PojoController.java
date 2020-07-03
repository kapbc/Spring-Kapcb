package com.kapcb.ccc.controller;

import com.kapcb.ccc.domain.Account;
import com.kapcb.ccc.domain.Address;
import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.util.StringToDateConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * <a>Title:PojoController</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/8 11:56
 */
@Controller
@RequestMapping(value = "account")
public class PojoController {


    /**
     * 类型绑定--pojo测试
     *
     * @param account Account
     * @return success
     */
    @RequestMapping(path = "saveAccount")
    public String saveAccountTest(Account account) {
        String name = account.getName();
        Float money = account.getMoney();
        Address address = account.getAddress();

        System.out.println("名称为:" + name + "余额为:" + money + "地址为:" + address);
        return "success";
    }

    /**
     * POJO 类中包含集合类型参数
     *
     * @param user User
     * @return success
     */
    @RequestMapping(path = "updateAccount")
    public String updateAccountTest(User user) {
        System.out.println(user);
        return "success";
    }

    /**
     * 自定义类型转换器
     *
     * @param date Date
     * @return success
     */
    @RequestMapping(path = "deleteAccount")
    public String deleteAccountTest(String date) {
        StringToDateConverter stringToDateConverter = new StringToDateConverter();
        Date convert = stringToDateConverter.convert(date);
        System.out.println(convert);
        return "success";
    }


    /**
     * 使用 ServletAPI 对象作为方法参数
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @param session  HttpSession
     * @return success
     */
    @RequestMapping("servletAPI")
    public String servletAPITest(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
        return "success";
    }
}
