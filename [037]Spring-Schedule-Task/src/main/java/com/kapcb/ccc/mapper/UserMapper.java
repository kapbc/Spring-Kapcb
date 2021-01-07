package com.kapcb.ccc.mapper;

import com.kapcb.ccc.domain.TestUser;
import org.springframework.stereotype.Repository;

/**
 * <a>Title: UserMapper </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/6 21:34
 */
public interface UserMapper {

    /**
     * get user info by user id
     *
     * @param userId String
     * @return TestUser
     */
    TestUser getUserByUserId(String userId);
}
