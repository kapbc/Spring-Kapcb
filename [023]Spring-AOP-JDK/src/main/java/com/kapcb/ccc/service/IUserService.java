package com.kapcb.ccc.service;


import com.kapcb.ccc.domain.User;

/**
 * <a>Title: IUserService </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/5 21:54
 */
public interface IUserService {

    /**
     * login
     *
     * @param username username {@link User#getUsername()}
     * @param password password {@link User#getPassword()}
     * @return User {@link User}
     */
    User login(String username, String password);
}
