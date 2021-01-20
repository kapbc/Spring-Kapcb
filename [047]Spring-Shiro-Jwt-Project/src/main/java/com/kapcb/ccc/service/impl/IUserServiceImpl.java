package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.commons.constants.Constant;
import com.kapcb.ccc.commons.domain.User;
import com.kapcb.ccc.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * <a>Title: IUserServiceImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/20-15:19
 */
@Slf4j
@Service("userService")
public class IUserServiceImpl implements IUserService {

    private static final List<User> USER_LIST = new ArrayList<>(Constant.SIXTEEN.getInt());

    static {
        USER_LIST.add(new User("kapcb", "", "eircccallroot@163.com", LocalDateTime.of(2021, 3, 11, 23, 59, 59), "Y"));
        USER_LIST.add(new User("eirc", "", "eircccallroot@126.com", LocalDateTime.of(2022, 3, 11, 23, 59, 59), "Y"));
    }

    @Override
    public User getUserByUsername(String username) {
        User user = USER_LIST.stream().filter(s -> Objects.equals(s.getUsername(), username)).findAny().orElseThrow(NoSuchElementException::new);
        log.warn("get the user of the username : " + username + " is : " + user);
        return user;
    }
}
