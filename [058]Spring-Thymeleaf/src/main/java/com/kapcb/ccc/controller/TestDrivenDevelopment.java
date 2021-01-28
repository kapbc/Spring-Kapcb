package com.kapcb.ccc.controller;

import com.kapcb.ccc.commons.domain.User;
import com.kapcb.ccc.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <a>Title: TestDrivenDevelopment </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/28 22:06
 */
@Slf4j
@Controller
@ResponseBody
@RequiredArgsConstructor
@RequestMapping(path = "/test")
public class TestDrivenDevelopment {

    private final IUserService userService;

    @GetMapping(path = "/one", produces = "application/json;chaset=utf-8")
    public String one(Model model) {
        log.warn("process the request in the controller");
        List<User> userList = userService.getUserList();
        model.addAttribute("result", userList);
        return "kapcb";
    }


}
