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
 * @date 2021/1/11 20:32
 */
@Slf4j
@Service("userService")
public class UserServiceImpl implements UserService {

    @Override
    public User getUserByUserName(String username) {
        if (StringUtils.isNotBlank(username) && StringUtils.equals("kapcb", username)) {
            User user = new User();
            user.setId(123456L);
            user.setUsername("kapcb");
            user.setPassword("123456");
            user.setBirthday(LocalDateTime.now());
        }
        return null;
    }
}
