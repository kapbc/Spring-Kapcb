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
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/12 20:53
 */
@Slf4j
@Service("userService")
public class IUserServiceImpl implements IUserService {

    @Override
    public User getUserByUsername(String username) {
        log.warn("username is : " + username);
        if (StringUtils.isNotBlank(username) && StringUtils.equals("kapcb", username)) {
            log.warn("query the user by username is : " + username);
            User user = new User();
            user.setUsername("kapcb");
            user.setPassword("123456");
            user.setEmail("eircccallroot@163.com");
            user.setBirthday(LocalDateTime.now());
            user.setAge(18);
            return user;
        }
        return null;
    }
}
