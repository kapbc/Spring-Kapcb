package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.service.IUserService;
import org.springframework.stereotype.Service;

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
        new User("")
    }
}
