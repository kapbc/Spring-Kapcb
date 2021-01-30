package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.domian.User;
import com.kapcb.ccc.mapper.UserMapper;
import com.kapcb.ccc.service.IUserService;

import java.util.List;

/**
 * <a>Title: IUserServiceImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/30 11:38
 */
public class IUserServiceImpl implements IUserService {

    @Override
    public List<User> getUserInfo() {
        return UserMapper.USER_LIST;
    }
}
