package com.kapcb.ccc.controller;

import com.kapcb.ccc.commons.annotation.Verified;
import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * <a>Title: ValidationController </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/21-16:27
 */
@Slf4j
@Validated
@Controller
@ResponseBody
@RequiredArgsConstructor
@RequestMapping("/validation")
public class ValidationController {

    private final IUserService userService;

    @PostMapping(value = "/insert", produces = "application/json;charset = UTF-8")
    public String signUp(@Verified User user) {
        boolean insert = userService.insert(user);
        log.info("user insert result is : " + insert);
        return insert ? "insert success" : "insert fail";
    }

}
