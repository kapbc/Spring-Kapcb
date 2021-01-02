package com.kapcb.ccc.controller;

import com.kapcb.ccc.common.ResultInfo;
import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.dto.Result;
import com.kapcb.ccc.service.IUserService;
import com.kapcb.ccc.utils.ResultConvertUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <a>Title: UserController </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/2 21:40
 */
@Slf4j
@Validated
@Controller
@RequestMapping("/kapcb")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @GetMapping(value = "/getUserInfoList", produces = "application/json; charset=UTF-8")
    public String getUserInfoList() {
        List<User> userInfoList = userService.getUserInfoList();
        Result<List<User>> result = new Result<>(ResultInfo.REQUEST_SUCCESS, userInfoList);
        return ResultConvertUtil.convertObjectToJsonString(result);
    }


}
