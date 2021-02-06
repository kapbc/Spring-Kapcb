package com.kapcb.ccc.mapper;

import com.kapcb.ccc.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <a>Title: IUserMapper </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/6 17:19
 */
public interface IUserMapper {

    /**
     * get user info list
     *
     * @return List<User>
     */
    List<User> getUserInfoList();
}
