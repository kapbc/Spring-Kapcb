package com.kapcb.ccc.mapper;

import com.kapcb.ccc.domian.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <a>Title: UserMapper </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/30 11:42
 */
public class UserMapper {

    private static final int INITIAL_CAPACITY = 8;
    public static final List<User> USER_LIST = new ArrayList<>(INITIAL_CAPACITY);

    private UserMapper() {
    }

    static {
        USER_LIST.add(new User(123456L, "Y", "kapcb", "123456", LocalDateTime.now()));
        USER_LIST.add(new User(123457L, "N", "ccc", "123457", LocalDateTime.now()));
        USER_LIST.add(new User(123458L, "N", "eee", "123458", LocalDateTime.now()));
        USER_LIST.add(new User(123459L, "Y", "bbb", "123459", LocalDateTime.now()));
    }
}
