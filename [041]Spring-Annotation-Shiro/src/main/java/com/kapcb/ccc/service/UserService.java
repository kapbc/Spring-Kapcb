package com.kapcb.ccc.service;

import com.kapcb.ccc.domain.User;

/**
 * <a>Title: UserService </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/10 21:54
 */
public interface UserService {

    User getUserByUserName(String username);
}
