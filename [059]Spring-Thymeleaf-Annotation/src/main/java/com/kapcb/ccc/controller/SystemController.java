package com.kapcb.ccc.controller;

import com.kapcb.ccc.commons.domian.User;
import com.kapcb.ccc.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <a>Title: SystemController </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/29 22:10
 */
@Slf4j
@Controller
@RequestMapping("/test")
@RequiredArgsConstructor
public class SystemController {

    private final IUserService userService;

    @GetMapping(path = "/one", produces = "application/json;charset=utf-8")
    public String one(Model model) {
        log.warn("come into the test code .... ");
        List<User> userInfo = userService.getUserInfo();
        model.addAttribute("userList", userInfo);
        return "kapcb";
    }
}
