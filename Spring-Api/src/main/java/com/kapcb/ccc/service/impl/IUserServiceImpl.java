package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.service.IUserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <a>Title: IUserServiceImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/1 21:24
 */
@Service("userService")
public class IUserServiceImpl implements IUserService {
    @Override
    public User getUserInfo(String userId) {
        User user = new User();
        user.setUserId(123456L);
        user.setUsername("kapcb");
        user.setEmail("eircccallroot@yeah.net");
        user.setFlag("Y");
        user.setTotalPoint(15590);
        user.setBirthday(LocalDateTime.now());
        return user;
    }
}
