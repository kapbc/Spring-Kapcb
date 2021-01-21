package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.commons.constants.Constant;
import com.kapcb.ccc.commons.domain.User;
import com.kapcb.ccc.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <a>Title: IUserServiceImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/20-15:19
 */
@Slf4j
@Service("userService")
public class IUserServiceImpl implements IUserService {

    private static final List<User> USER_LIST = new ArrayList<>(Constant.SIXTEEN.getInt());

    /**
     * password are all self username
     */
    static {
        USER_LIST.add(new User(66666L, "kapcb", "a41587a431d850b599202e277550600cee431c39", "eircccallroot@163.com", LocalDateTime.of(2021, 3, 11, 23, 59, 59), "Y"));
        USER_LIST.add(new User(88888L, "eirc", "b3375cff8041d5ce62104ecd74e2b253afbe437c", "eircccallroot@126.com", LocalDateTime.of(2022, 3, 11, 23, 59, 59), "Y"));
    }

    @Override
    public User getUserByUsername(String username) {
        User user = USER_LIST.stream().filter(s -> Objects.equals(s.getUsername(), username)).findAny().orElseGet(User::new);
        log.warn("get the user of the username : " + username + " is : " + user);
        return user;
    }

    @Override
    public List<User> getUserInfoList() {
        return USER_LIST;
    }

    /**
     * JUST FOR TEST THE DATA
     * just for simulation the data form DB
     * if is the real development scene, no need to convert the Type of arguments userId
     *
     * @param userId String
     * @return boolean
     */
    @Override
    public boolean deleteUserByUserId(String userId) {
        return USER_LIST.stream().map(User::getUserId).anyMatch(Long.valueOf(userId)::equals);
    }

    /**
     * JUST FOR TEST THE DATA
     * just for simulation the data form DB
     * if is the real development scene, no need to convert the Type of arguments userId
     *
     * @param userId String
     * @return boolean
     */
    @Override
    public boolean updateUserInfoByUserId(String userId) {
        return USER_LIST.stream().map(User::getUserId).anyMatch(Long.valueOf(userId)::equals);
    }
}
