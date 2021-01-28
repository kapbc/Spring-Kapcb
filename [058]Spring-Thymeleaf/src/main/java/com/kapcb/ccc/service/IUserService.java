package com.kapcb.ccc.service;

import com.kapcb.ccc.commons.domain.User;

import java.util.List;

/**
 * <a>Title: IUserService </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/28 22:08
 */
public interface IUserService {

    /**
     * get user{@link User} list
     * {@see }
     * @return List<User>
     */
    List<User> getUserList();
}
