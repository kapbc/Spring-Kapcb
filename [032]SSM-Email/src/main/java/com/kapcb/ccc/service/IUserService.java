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
 * @date 2020/12/23 - 21:23
 */
public interface IUserService {

    List<User> getUserListForEmail();

    User getUserInfoByUserId(Long userId);
}
