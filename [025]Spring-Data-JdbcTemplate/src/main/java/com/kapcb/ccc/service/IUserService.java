package com.kapcb.ccc.service;

import com.kapcb.ccc.domain.User;

import java.util.List;

/**
 * <a>Title: IUserService </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/6 16:44
 */
public interface IUserService {

    /**
     * get user info list
     *
     * @return List<User>
     */
    List<User> getUserInfoList();
}
