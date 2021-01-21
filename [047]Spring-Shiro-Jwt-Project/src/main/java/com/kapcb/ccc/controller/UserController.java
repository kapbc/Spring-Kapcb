package com.kapcb.ccc.controller;

import com.kapcb.ccc.commons.constants.ResultInfo;
import com.kapcb.ccc.commons.domain.Result;
import com.kapcb.ccc.commons.domain.User;
import com.kapcb.ccc.commons.utils.JsonUtil;
import com.kapcb.ccc.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <a>Title: UserController </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/20 22:42
 */
@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/kapcb")
public class UserController {

    private final IUserService userService;

    @ResponseBody
    @RequiresRoles(value = {"admin", "user"})
    @RequiresPermissions("get:userInfo")
    @GetMapping(path = "/getUserInfoList", produces = "application/json; charset = UTF-8")
    public String getUserInfoList() {
        log.warn("process the get user info list");
        List<User> userInfoList = userService.getUserInfoList();
        return JsonUtil.convertToJsonString(new Result<>(ResultInfo.SUCCESS, userInfoList));
    }

    @ResponseBody
    @RequiresRoles("admin")
    @RequiresPermissions("delete:userInfo")
    @PostMapping(path = "/deleteUserByUserId", produces = "application/json; charset = UTF-8")
    public String deleteUserByUserId(@RequestParam(value = "userId", required = true) String userId) {
        log.warn("process the delete user by user id");
        Result<Object> result = userService.deleteUserByUserId(userId) ? new Result<>(ResultInfo.SUCCESS) : new Result<>(ResultInfo.FAIL);
        return JsonUtil.convertToJsonString(result);
    }

    @ResponseBody
    @RequiresRoles("user")
    @RequiresPermissions("update:userInfo")
    @PostMapping(path = "/updateUserInfoByUserId", produces = "application/json; charset = UTF-8")
    public String updateUserInfoByUserId(@RequestParam(value = "userId", required = true) String userId) {
        log.warn("process the update user info by user id");
        Result<Object> result = userService.updateUserInfoByUserId(userId) ? new Result<>(ResultInfo.SUCCESS) : new Result<>(ResultInfo.FAIL);
        return JsonUtil.convertToJsonString(result);
    }

}
