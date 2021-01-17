package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <a>Title: IUserServiceImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/17 22:42
 */
@Service("userService")
public class IUserServiceImpl implements IUserService {
    @Override
    public boolean getUserByUsername(String username, String password) {
        return "kapcb".equals(username) && "123456".equals(password);
    }
}
