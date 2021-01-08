package com.kapcb.ccc.controller;

import com.kapcb.ccc.common.bean.ResultBean;
import com.kapcb.ccc.common.dto.ResultInfo;
import com.kapcb.ccc.common.utils.JsonUtil;
import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

/**
 * <a>Title: TestDrivenDevelopment </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/8 20:26
 */
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/kapcb")
public class TestDrivenDevelopment {

    private final UserService userService;

    @ResponseBody
    @PostMapping(path = "/test/{userId}", produces = "application/json;charset=UTF-8")
    public String testDrivenDevelopment(@PathVariable String userId) {
        log.warn("userId is : " + userId);
        User result = userService.getUserByUserId(userId);
        if (Objects.equals(null, result)) {
            return JsonUtil.convertObjectBeanToJsonString(null);
        }
        return JsonUtil.convertObjectBeanToJsonString(new ResultBean<>(ResultInfo.SUCCESS, result));
    }
}
