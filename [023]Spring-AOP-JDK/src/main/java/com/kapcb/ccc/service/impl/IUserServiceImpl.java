package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * <a>Title: IUserServiceImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/5 22:02
 */
@Service("userService")
public class IUserServiceImpl implements IUserService {

    private static final String USER_NAME = "kapcb";
    private static final String PASS_WORD = "123456";

    @Override
    public User login(String username, String password) {
        System.out.println("begin to process the user login in IUserServiceImpl");
        User user = null;
        if (StringUtils.equalsIgnoreCase(username, USER_NAME) && StringUtils.equalsIgnoreCase(password, PASS_WORD)) {
            user = new User("kapcb", "123456");
        }
        System.out.println("process user login success in IUserServiceImpl");
        return Optional.ofNullable(user).orElseGet(User::new);
    }
}
