package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.commons.domain.User;
import com.kapcb.ccc.commons.pool.DataPool;
import com.kapcb.ccc.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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


}
