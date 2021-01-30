package com.kapcb.ccc.service;

import com.kapcb.ccc.domain.User;

/**
 * <a>Title: IUserService </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/30 21:30
 */
public interface IUserService {

    /**
     * get user by user name
     *
     * @param username String
     * @return {@link User}
     */
    User getUserByUsername(String username);
}
