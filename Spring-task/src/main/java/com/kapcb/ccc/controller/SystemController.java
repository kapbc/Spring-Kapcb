package com.kapcb.ccc.controller;

import com.kapcb.ccc.common.constants.ResultInfo;
import com.kapcb.ccc.common.dto.Result;
import com.kapcb.ccc.domain.TestUser;
import com.kapcb.ccc.service.IUserService;
import com.kapcb.ccc.utils.JsonUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * <a>Title: SystemController </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/6 21:23
 */
@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/kapcb")
public class SystemController {

    private final IUserService userService;

    @ResponseBody
    @PostMapping(path = "/test/{userId}", produces = "application/json; charset=UTF-8")
    public String test(@NotNull(message = "{userId is required}") @PathVariable String userId) {
        TestUser userInfo = userService.getUserByUserId(userId);
        log.warn("user info ::: " + userInfo);
        if (Objects.equals(userInfo, null)) {
            log.warn("user is null");
            return JsonUtil.convertResultToJsonForApi(new Result<>(ResultInfo.FAIL));
        }
        String jsonString = JsonUtil.convertResultToJsonForApi(new Result<>(ResultInfo.SUCCESS, userInfo));
        log.warn("jsonString ::: " + jsonString);
        return jsonString;
    }
}
