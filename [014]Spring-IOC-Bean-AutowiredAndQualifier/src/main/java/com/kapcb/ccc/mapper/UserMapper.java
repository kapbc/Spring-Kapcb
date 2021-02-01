package com.kapcb.ccc.mapper;

import com.kapcb.ccc.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * <a>Title: UserMapper </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/1 21:27
 */
@Repository(value = "userMapper")
public class UserMapper {

    @SuppressWarnings("serial")
    public List<User> getUserInfo() {
        return new ArrayList<User>() {
            {
                add(new User(1L, "kapcb"));
                add(new User(2L, "aaa"));
                add(new User(3L, "bbb"));
                add(new User(4L, "ccc"));
                add(new User(5L, "ddd"));
            }
        };
    }
}
