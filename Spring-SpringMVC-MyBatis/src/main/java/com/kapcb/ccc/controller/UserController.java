package com.kapcb.ccc.controller;

import com.kapcb.ccc.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <a>Title: UserController </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/27 - 18:38
 */
@Controller
@Validated
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @ResponseBody
    @GetMapping(value = "/getUserById/{userId}")
    public String execute(@NotBlank(message = "{required}") @PathVariable String userId) {
        userService.getUserInfoByUserId(1L);
        System.out.println("get the user info which id is : " + userId);
        return "success";
    }

}
