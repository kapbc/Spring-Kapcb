package com.kapcb.ccc.service;

import com.kapcb.ccc.commons.domain.User;

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
}
