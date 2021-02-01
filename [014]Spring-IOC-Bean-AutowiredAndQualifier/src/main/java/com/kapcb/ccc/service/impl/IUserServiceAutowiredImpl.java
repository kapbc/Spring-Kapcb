package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.mapper.UserMapper;
import com.kapcb.ccc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <a>Title: IUserServiceImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/1 21:27
 */
@Component(value = "userServiceAutowired")
public class IUserServiceAutowiredImpl implements IUserService {

    @Value(value = "abc")
    private String name;

    /**
     * 根据类型进行依赖注入
     */
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserInfo() {
        System.out.println(name);
        return userMapper.getUserInfo();
    }
}
