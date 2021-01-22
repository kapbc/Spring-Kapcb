package com.kapcb.ccc.controller;

import com.kapcb.ccc.commons.constant.ResultInfo;
import com.kapcb.ccc.commons.domain.Result;
import com.kapcb.ccc.commons.domain.User;
import com.kapcb.ccc.commons.utils.json.JsonUtil;
import com.kapcb.ccc.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <a>Title: UserController </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/22-15:50
 */
@Slf4j
@Controller
@ResponseBody
@RequiredArgsConstructor
@RequestMapping(path = "/kapcb")
public class UserController {

    private final IUserService userService;

    @RequiresRoles(value = "admin")
    @RequiresPermissions(value = "")
    @PostMapping(path = "/getUserInfo", produces = "application/json;charset= UTF-8")
    public String getUserInfo() {
        log.info("begin to process the get user info");
        List<User> resultList = userService.getUserInfo();
        return JsonUtil.convertResultToJsonString(new Result<>(ResultInfo.SUCCESS, resultList));
    }

    @RequiresRoles("")
    @RequiresPermissions("")
    @DeleteMapping(path = "/deleteUserById")
    public String deleteUserById(@RequestParam(value = "userId", required = true) String userId) {
        Result<Object> result = new Result<>(ResultInfo.FAIL);
        if (userService.deleteUserById(userId)) {
            log.info("delete the user by id success");
            result = new Result<>(ResultInfo.SUCCESS);
        }
        return JsonUtil.convertResultToJsonString(result);
    }

    @RequiresRoles("")
    @RequiresPermissions("")
    @PostMapping(path = "/getUserById", produces = "application/json;charset = UTF-8")
    public String getUserById(@RequestParam(value = "userId", required = true) String userId) {
        User user = userService.getUserById(userId);
        log.info("the result of the id : " + userId + " is : " + userId);
        return JsonUtil.convertResultToJsonString(new Result<>(ResultInfo.SUCCESS, user));
    }

    @RequiresRoles("")
    @RequiresPermissions("")
    @PostMapping(path = "/updateUserById", produces = "application/json;charset=UTF-8")
    public String updateUserById(@RequestParam(value = "userId", required = true) String userId) {
        Result<Object> result = new Result<>(ResultInfo.FAIL);
        if (userService.updateUserById(userId)) {
            log.info("update user by id success");
            result = new Result<>(ResultInfo.SUCCESS);
        }
        return JsonUtil.convertResultToJsonString(result);
    }

    @RequiresRoles("")
    @RequiresPermissions("")
    @PatchMapping(path = "/insertUser", produces = "application/json;charset = UTF-8")
    public String insertUser(@RequestParam(value = "userId", required = true) String userId) {
        Result<Object> result = new Result<>(ResultInfo.FAIL);
        if (userService.insertUser(userId)) {
            log.info("insert user success");
            result = new Result<>(ResultInfo.SUCCESS);
        }
        return JsonUtil.convertResultToJsonString(result);
    }
}
