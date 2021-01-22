package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.commons.domain.User;
import com.kapcb.ccc.commons.pool.DataPool;
import com.kapcb.ccc.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <a>Title: IUserServiceImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/22-9:22
 */
@Slf4j
@Service(value = "userService")
public class IUserServiceImpl implements IUserService {


    @Override
    public User getUserInfoByUsername(String username) {
        log.info("begin to process the get user info by username");
        User user = DataPool.userMap.getOrDefault(username, new User());
        log.info("the user for data pool is : " + user);
        return user;
    }

    @Override
    public List<User> getUserInfo() {
        List<User> userList = DataPool.userMap.values().stream().collect(Collectors.toList());
        log.info("the user list is : " + userList);
        return userList == null ? Collections.emptyList() : userList;
    }

    @Override
    public User getUserById(String id) {
        log.info("process the get user by id");
        return DataPool.userMap
                .values().stream()
                .filter(s -> StringUtils.equals(s.getUserId().toString(), id))
                .findAny()
                .orElseGet(User::new);
    }

    @Override
    public boolean deleteUserById(String id) {
        log.info("process delete user by id");
        return getTheUserIsExist(id);
    }

    @Override
    public boolean updateUserById(String id) {
        log.info("process update user by id");
        return getTheUserIsExist(id);
    }

    @Override
    public boolean insertUser(String id) {
        log.info("process insert user");
        return !getTheUserIsExist(id);
    }

    private boolean getTheUserIsExist(String id) {
        log.info("get the user form the data pool");
        Long userId = Long.valueOf(id);
        log.info("the user id is : " + userId);
        return DataPool.userMap
                .values().stream()
                .map(User::getUserId)
                .anyMatch(userId::equals);
    }

}
