package com.kapcb.ccc.service;

import com.kapcb.ccc.domain.User;

/**
 * <a>Title: UserService </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/8 20:36
 */
public interface UserService {

    /**
     * get user info by user id
     *
     * @param userId String
     * @return User
     */
    User getUserByUserId(String userId);

    /**
     * get user by user name
     *
     * @param userName String
     * @return User
     */
    User getUserByUsername(String userName);
}
