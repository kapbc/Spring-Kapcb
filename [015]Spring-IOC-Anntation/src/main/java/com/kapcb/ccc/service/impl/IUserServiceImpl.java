package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.mapper.UserMapper;
import com.kapcb.ccc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * <a>Title: IUserServiceImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/1 22:33
 */
@Component(value = "userService")
public class IUserServiceImpl implements IUserService {

    @Autowired
    @Qualifier(value = "userMapper")
    private UserMapper userMapper;

    @Override
    public User getUserInfo() {
        return userMapper.getUserInfo();
    }
}
