package com.kapcb.ccc.service;

import com.kapcb.ccc.domain.User;

import java.util.List;

/**
 * <a>Title: UserService </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/10 21:54
 */
public interface UserService {

    /**
     * get user by user name
     *
     * @param username username
     * @return User
     */
    User getUserByUserName(String username);

    /**
     * get user info
     *
     * @return List<User>
     */
    List<User> getUserInfo();
}
