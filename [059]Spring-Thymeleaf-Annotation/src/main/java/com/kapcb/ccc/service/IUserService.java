package com.kapcb.ccc.service;

import com.kapcb.ccc.commons.domian.User;
import com.kapcb.ccc.service.impl.IUserServiceImpl;

import java.util.List;

/**
 * <a>Title: IUserService </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/29 22:12
 */
public interface IUserService {

    /**
     * get user info{@link IUserServiceImpl#getUserInfo()}
     *
     * @return List<User>
     */
    List<User> getUserInfo();
}
