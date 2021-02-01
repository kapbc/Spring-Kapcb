package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.mapper.UserMapper;
import com.kapcb.ccc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <a>Title: IUserServiceQualifierImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/1 21:38
 */
@Service(value = "userServiceQualifier")
public class IUserServiceQualifierImpl implements IUserService {

    /**
     * 先根据类型进行依赖注入,
     * 如果匹配到多个相同类型的Bean, 则再根据名称进行匹配注入
     */
    @Autowired
    @Qualifier(value = "userMapper")
    private UserMapper userMapper;

    @Override
    public List<User> getUserInfo() {
        return userMapper.getUserInfo();
    }
}
