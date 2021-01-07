package com.kapcb.ccc.controller;

import com.kapcb.ccc.common.bean.ResultStatusInfo;
import com.kapcb.ccc.common.result.Result;
import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.service.IUserService;
import com.kapcb.ccc.utils.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotNull;

/**
 * <a>Title: SystemController </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/7-10:32
 */
@Controller
@RequestMapping(value = "/kapcb")
@RequiredArgsConstructor
public class SystemController {

    private final IUserService userService;

    @ResponseBody
    @PostMapping(path = "/test/{userId}", produces = "application/json; charset=UTF-8")
    public String frameWorkCreateTest(@NotNull(message = "{required}") @PathVariable String userId) {
        User user = userService.getUserById(userId);
        if (StringUtils.isBlank(userId)) {
            return JsonUtil.convertBeanToJsonString(new Result<>(ResultStatusInfo.FAIL, user));
        }
        return JsonUtil.convertBeanToJsonString(new Result<>(ResultStatusInfo.SUCCESS, user));
    }
}
