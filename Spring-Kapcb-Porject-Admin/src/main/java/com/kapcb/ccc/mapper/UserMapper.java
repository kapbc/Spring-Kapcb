package com.kapcb.ccc.mapper;

import com.kapcb.ccc.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <a>Title: UserMapper </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/2 21:56
 */
@Repository
public interface UserMapper {

    /**
     * get user info list for display
     *
     * @return List<User>
     */
    List<User> getUserInfoList();
}
