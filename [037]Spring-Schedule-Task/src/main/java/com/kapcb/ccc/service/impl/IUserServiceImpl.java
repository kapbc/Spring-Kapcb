package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.domain.TestUser;
import com.kapcb.ccc.mapper.UserMapper;
import com.kapcb.ccc.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * <a>Title: IUserServiceImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/6 21:36
 */
@Slf4j
@Service("userService")
public class IUserServiceImpl implements IUserService {

    @Override
    public TestUser getUserByUserId(String userId) {
        log.info("come into getUserByUserId, prepare to process the service");
        return (StringUtils.isNoneBlank(userId) && Objects.equals("123456", userId)) ? getTestData(userId) : null;
    }

    public TestUser getTestData(String userId) {
        log.warn("userId is ::: " + userId);
        TestUser testUser = new TestUser();
        testUser.setName("kapcb");
        testUser.setEmail("eircccallroot@163.com");
        testUser.setUserId(123456L);
        testUser.setLocalDateTime(LocalDateTime.now());
        return testUser;
    }

}