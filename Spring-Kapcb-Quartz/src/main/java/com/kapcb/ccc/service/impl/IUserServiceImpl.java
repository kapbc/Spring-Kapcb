package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <a>Title: IUserServiceImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/7-10:58
 */
@Slf4j
@Service(value = "userService")
public class IUserServiceImpl implements IUserService {

    @Override
    public User getUserById(String userId) {
        if (StringUtils.isNotBlank(userId)) {
            log.warn("get user by id");
            return getGeneratorUserData(userId);
        }
        log.warn("get test user without user id");
        return new User("test", "eircccallroot@yeah.net", "test", LocalDateTime.now());
    }

    private User getGeneratorUserData(String userId) {
        log.warn("prepare to get generator user data by user id is ::: " + userId);
        User user = new User();
        user.setName("kapcb");
        user.setPassword("123456");
        user.setEmail("eircccallroot@163.com");
        user.setLocalDateTime(LocalDateTime.now());
        return user;
    }
}
