package com.kapcb.ccc.service;

import com.kapcb.ccc.domian.User;
import com.kapcb.ccc.service.impl.IUserServiceImpl;

import java.util.List;

/**
 * <a>Title: IUserService </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/30 11:35
 */
public interface IUserService {

    /**
     * get user info
     * {@link User}
     * {@link IUserServiceImpl#getUserInfo()}
     *
     * @return List<User>
     */
    List<User> getUserInfo();
}
