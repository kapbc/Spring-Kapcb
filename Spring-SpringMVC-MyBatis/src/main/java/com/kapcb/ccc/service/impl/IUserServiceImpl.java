package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.mapper.UserMapper;
import com.kapcb.ccc.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <a>Title: IUserServiceImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/27 - 18:39
 */
@Service("userService")
public class IUserServiceImpl implements IUserService {

    private UserMapper userMapper;


    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }


    @Override
    public User getUserInfoByUserId(Long userId) {
        System.out.println("Come into getUserInfoByUserId...");
        //return userMapper.getUserInfoByUserId(userId);
        return null;
    }

    @Override
    public boolean addUser() {
        return userMapper.addUser();
    }

    @Override
    public boolean modifyUser() {
        return userMapper.modifyUser();
    }

    @Override
    public boolean deleteUserByUserId(Long userId) {
        return userMapper.deleteUserByUserId(userId);
    }

    @Override
    public boolean deleteUserByUserIdBatch(String[] userIds) {
        return deleteUserByUserIdBatch(userIds);
    }
}
