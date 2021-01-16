package com.kapcb.ccc.service;

import com.kapcb.ccc.domain.User;

import java.util.List;

/**
 * <a>Title: IUserService </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/12 20:47
 */
public interface IUserService {

    /**
     * get user by user name
     *
     * @param username String
     * @return User
     */
    User getUserByUsername(String username);

}
