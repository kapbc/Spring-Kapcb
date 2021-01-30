package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.service.IUserService;

import java.time.LocalDateTime;

/**
 * <a>Title: IUserServiceImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/30 21:31
 */
public class IUserServiceImpl implements IUserService {

    private static final String USER_NAME = "kapcb";

    public IUserServiceImpl() {
        System.out.println("IUserServiceImpl begin to initial....");
    }

    @Override
    public User getUserByUsername(String username) {
        if (USER_NAME.equals(username)) {
            return new User(123456L, "Y", "kapcb", "123456", LocalDateTime.now());
        }
        return null;
    }
}
