package com.kapcb.ccc.service;

import com.kapcb.ccc.commons.domain.User;

import java.util.List;

/**
 * <a>Title: IUserService </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/22-9:22
 */
public interface IUserService {

    /**
     * get user info by username
     *
     * @param username String
     * @return User
     */
    User getUserInfoByUsername(String username);

    /**
     * get user info
     *
     * @return List<User>
     */
    List<User> getUserInfo();

    /**
     * get user by user id
     *
     * @param id String
     * @return User
     */
    User getUserById(String id);

    /**
     * delete user by id
     *
     * @param id String
     * @return boolean
     */
    boolean deleteUserById(String id);

    /**
     * update user by id
     *
     * @param id String
     * @return boolean
     */
    boolean updateUserById(String id);

    /**
     * insert user
     *
     * @param id String
     * @return boolean
     */
    boolean insertUser(String id);
}
