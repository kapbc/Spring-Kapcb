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
 * @date 2021/1/20-15:19
 */
public interface IUserService {

    /**
     * get user by username
     *
     * @param username String
     * @return User
     */
    User getUserByUsername(String username);

    /**
     * get user info list
     *
     * @return List<User>
     */
    List<User> getUserInfoList();

    /**
     * delete user by user id
     *
     * @param userId String
     * @return boolean
     */
    boolean deleteUserByUserId(String userId);
}
