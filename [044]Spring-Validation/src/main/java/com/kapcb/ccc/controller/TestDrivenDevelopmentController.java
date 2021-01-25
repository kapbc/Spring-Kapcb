package com.kapcb.ccc.controller;

import com.kapcb.ccc.commons.annotation.Constraints;
import com.kapcb.ccc.commons.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



/**
 * <a>Title: TestDrivenDevelopmentController </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/25-9:24
 */
@Validated
@Controller
@ResponseBody
@RequestMapping(path = "/test")
public class TestDrivenDevelopmentController {

    private static final Logger log = LoggerFactory.getLogger(TestDrivenDevelopmentController.class);

    @PostMapping(path = "/validation", produces = "application/json;charset=utf-8")
    public String validation(@Validated User user) {
        log.info("the user is : " + user);
        System.out.println("user.getAge() = " + user.getAge());
        log.info("process bean validation success");
        return "success";
    }

    @GetMapping(path = "/single", produces = "application/json;charset= UTF-8")
    public String single(@Validated @Constraints(contains = "kapcb") String str) {
        log.info("the str is : " + str);
        return "success";
    }

}
