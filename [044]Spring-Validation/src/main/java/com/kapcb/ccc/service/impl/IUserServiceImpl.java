package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.commons.domain.User;
import com.kapcb.ccc.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <a>Title: IUserServiceImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/23 10:47
 */
@Slf4j
@Service(value = "userService")
public class IUserServiceImpl implements IUserService {

    @Override
    public boolean insert(User user) {
        log.info("the insert user is : " + user);
        return user != null;
    }
}
