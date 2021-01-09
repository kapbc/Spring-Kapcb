package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        User user = new User();
        if (StringUtils.isNotBlank(userId)) {
            user.setUserId(12345L);
            user.setUserName("kapcb");
            user.setAge(18);
            user.setBirthday(LocalDateTime.now());
        }
        return user;
    }

    @Override
    public User getUserByUsername(String userName) {
        User user = new User();
        if (StringUtils.isNotBlank(userName) && Objects.equals("kapcb", userName)) {
            user.setUserId(12345L);
            user.setUserName("kapcb");
            user.setAge(18);
            user.setPassWord("123456");
            user.setBirthday(LocalDateTime.now());
        }
        return user;
    }

    @Override
    public List<User> getUserInfo() {
        List<User> resultList = new ArrayList<>();
        resultList.add(new User("kapcb", 12345L, "123456", "asdasd", 18, LocalDateTime.now()));
        resultList.add(new User("ccc", 12346L, "123456", "dasdas", 19, LocalDateTime.now()));
        resultList.add(new User("eee", 12347L, "123456", "dasdasd", 20, LocalDateTime.now()));
        return resultList;
    }
}
