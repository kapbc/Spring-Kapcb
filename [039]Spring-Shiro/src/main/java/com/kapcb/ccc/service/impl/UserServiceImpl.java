package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <a>Title: UserServiceImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/8 20:37
 */
@Slf4j
@Service("userService")
public class UserServiceImpl implements UserService {
    @Override
    public User getUserByUserId(String userId) {
        if (StringUtils.isNotBlank(userId)) {
            User user = new User();
            user.setUserId(12345L);
            user.setUserName("kapcb");
            user.setAge(18);
            user.setBirthday(LocalDateTime.now());
            return user;
        }
        return new User();
    }
}
