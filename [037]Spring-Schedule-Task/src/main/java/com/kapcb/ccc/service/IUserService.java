package com.kapcb.ccc.service;

import com.kapcb.ccc.domain.TestUser;

/**
 * <a>Title: IUserService </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/6 21:35
 */
public interface IUserService {

    /**
     * get user info by user id
     *
     * @param userId String
     * @return TestUser
     */
    TestUser getUserByUserId(String userId);
}