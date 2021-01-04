package com.kapcb.ccc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kapcb.ccc.common.json.ConvertJsonFromApi;
import com.kapcb.ccc.common.result.Result;
import com.kapcb.ccc.common.result.ResultInfo;
import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.constraints.NotNull;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <a>Title: UserAPIController </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/1 1:22
 */
@Validated
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/kapcb/api/v1")
public class UserApiController {

    private static final Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    private final IUserService userService;

    @ResponseBody
    @GetMapping(path = "/a/{userId}")
    public void get(@PathVariable String userId) {
        System.out.println("获取到路径参数" + userId);
    }

    @ResponseBody
    @GetMapping(path = "/getUserInfo/{userId}", produces = "application/json; charset=UTF-8")
    public String getUserInfo(@NotNull(message = "required") @PathVariable String userId) {
        logger.warn("--- Into The Api Call---");
        ObjectMapper mapper = new ObjectMapper();
        String result;
        Result<User> userResult = null;
        ThreadFactory threadFactory = new CustomizableThreadFactory("Kapcb-Thread-Pool-");
        BlockingDeque<Runnable> deque = new LinkedBlockingDeque<>(20);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5, 50, TimeUnit.MILLISECONDS, deque, threadFactory);
        Future<User> future = executor.submit(() -> userService.getUserInfo(userId));
        try {
            User user = future.get(2, TimeUnit.SECONDS);
            userResult = new Result<>(ResultInfo.REQUEST_SUCCESS, user);
        } catch (Exception e) {
            future.cancel(true);
            logger.error("---request process time out---" + e.getMessage());
            userResult = new Result<>(ResultInfo.REQUEST_FAIL);
        }
        return ConvertJsonFromApi.convertObjectToJsonByTryCatch(userResult);
    }
}
