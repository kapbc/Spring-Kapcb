package com.kapcb.ccc.controller;

import com.kapcb.ccc.domain.Account;
import com.kapcb.ccc.utils.StringToDateConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Objects;

/**
 * <a>Title: ObjectBeanController </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/14 15:39
 */
@Controller
@RequestMapping(value = "objectBean")
public class ObjectBeanController {

    private static final Logger log = LoggerFactory.getLogger(ObjectBeanController.class);

    private static final String FAIl = "/test/fail";
    private static final String SUCCESS = "/test/success";

    /**
     * 型绑定--ObjectBean测试
     *
     * @param account Account
     * @return String
     */
    @PostMapping(value = "saveAccount", produces = "application/json; charset=UTF-8")
    public String saveAccount(Account account) {
        if (Objects.equals(null, account)) {
            return FAIl;
        }
        System.out.println("account = " + account);
        return SUCCESS;
    }

    /**
     * ObjectBean 类中包含集合类型参数
     *
     * @param account Account
     * @return String
     */
    @PostMapping(path = "updateAccount", produces = "application/json; charset=UTF-8")
    public String updateUser(Account account) {
        if (Objects.equals(null, account)) {
            return FAIl;
        }
        System.out.println("Account = " + account);
        return SUCCESS;
    }

    /**
     * 自定义类型转换器
     *
     * @param date String
     * @return String
     */
    @DeleteMapping(path = "delete", produces = "application/json; charset=UTF-8")
    public String delete(String date) {
        log.warn("the date is : " + date);
        StringToDateConverter stringToDateConverter = new StringToDateConverter();
        Date convert = stringToDateConverter.convert(date);
        log.warn("convert date is : " + convert);
        System.out.println("convert = " + convert);
        return SUCCESS;
    }


    /**
     * 使用 servletAPI 对象作为方法参数
     *
     * @param request  HttpServletRequest
     * @param response HttpServletResponse
     * @param session  HttpSession
     * @return String
     */
    @GetMapping(path = "servletAPI", produces = "application/json; charset=UTF-8")
    public String servletAPI(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        System.out.println("request = " + request);
        System.out.println("response = " + response);
        System.out.println("session = " + session);
        return SUCCESS;
    }
}
