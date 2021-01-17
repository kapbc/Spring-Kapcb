package com.kapcb.ccc.service;


/**
 * <a>Title: IUserService </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/17 22:37
 */
public interface IUserService {

    /**
     * get user by user name
     *
     * @param username String
     * @param password String
     * @return User
     */
    boolean getUserByUsername(String username, String password);
}
