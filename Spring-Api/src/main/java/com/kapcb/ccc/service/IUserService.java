package com.kapcb.ccc.service;

import com.kapcb.ccc.domain.User;

/**
 * <a>Title: IUserService </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/1 21:24
 */
public interface IUserService {

    /**
     * get user info by userId
     *
     * @param userId String
     * @return User
     */
    User getUserInfo(String userId);
}
