package com.kapcb.ccc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kapcb.ccc.common.Result;
import com.kapcb.ccc.common.ResultInfo;
import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.scheduling.concurrent.CustomizableThreadFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;
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

    private static final Logger logger = Logger.getLogger(UserApiController.class);

    private final IUserService userService;

    @PostMapping(name = "/getUserInfo/{userId}", produces = "application/json; charset=UTF-8")
    public String getUserInfo(@NotNull(message = "required") @PathVariable String userId) {
        ObjectMapper mapper = new ObjectMapper();
        String result;
        ThreadFactory threadFactory = new CustomizableThreadFactory("Kapcb-Thread-Pool-");
        BlockingDeque<Runnable> deque = new LinkedBlockingDeque<>(20);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5, 50, TimeUnit.MILLISECONDS, deque, threadFactory);
        Future<User> future = executor.submit(() -> {
            User userInfo = userService.getUserInfo(userId);
            return userInfo;
        });
        try {
            User user = future.get(2, TimeUnit.SECONDS);
            Result<User> userResult = new Result<>(ResultInfo.REQUEST_SUCCESS, user);
            result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(userResult);
        } catch (Exception e) {
            future.cancel(true);
            logger.error("---request process time out---" + e.getMessage());
            Result<Object> objectResult = new Result<>(ResultInfo.REQUEST_FAIL);
            result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectResult);
        }

        return null;
    }
}
