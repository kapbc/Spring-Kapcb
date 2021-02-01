package com.kapcb.ccc.service;

import com.kapcb.ccc.domain.User;


/**
 * <a>Title: IUserService </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/1 22:31
 */
public interface IUserService {

    /**
     * get user info
     *
     * @return {@link User}
     */
    User getUserInfo();
}
