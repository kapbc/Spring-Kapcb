package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.mapper.UserMapper;
import com.kapcb.ccc.service.IUserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * <a>Title: IUserServiceResourceImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/1 21:44
 */
@Component("userServiceResource")
public class IUserServiceResourceImpl implements IUserService {

    /**
     * 根据名称进行依赖注入
     */
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> getUserInfo() {
        return userMapper.getUserInfo();
    }
}
