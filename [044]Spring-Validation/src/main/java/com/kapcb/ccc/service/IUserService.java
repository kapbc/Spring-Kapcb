package com.kapcb.ccc.service;


import com.kapcb.ccc.commons.domain.User;

/**
 * <a>Title: IUserService </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/23 10:46
 */
public interface IUserService {

    /**
     * insert user
     * @param user User
     * @return boolean
     */
    boolean insert(User user);
}
