package com.kapcb.ccc.mapper.impl;

import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.mapper.UserMapper;
import org.springframework.stereotype.Repository;

/**
 * <a>Title: UserMapperImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/1 22:34
 */
@Repository(value = "userMapper")
public class UserMapperImpl implements UserMapper {

    @Override
    public User getUserInfo() {
        return new User(123456L, "kapcb");
    }
}
