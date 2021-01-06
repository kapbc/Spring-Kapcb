package com.kapcb.ccc.mapper.impl;

import com.kapcb.ccc.domain.TestUser;
import com.kapcb.ccc.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

/**
 * <a>Title: UserMapperImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/6 21:43
 */
@Slf4j
public class UserMapperImpl implements UserMapper {

    @Override
    public TestUser getUserByUserId(String userId) {
        log.warn("userId is ::: " + userId);
        TestUser testUser = new TestUser();
        testUser.setName("kapcb");
        testUser.setEmail("eircccallroot@163.com");
        testUser.setUserId(123456L);
        testUser.setLocalDateTime(LocalDateTime.now());
        return testUser;
    }
}
