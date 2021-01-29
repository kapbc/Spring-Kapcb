package com.kapcb.ccc.mapper;

import com.kapcb.ccc.commons.domian.User;
import lombok.extern.slf4j.Slf4j;

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
 * @date 2021/1/29 22:13
 */
@Slf4j
public class UserMapper {

    public static final List<User> USER_LIST = new ArrayList<>();

    private UserMapper(){}

    static {
        USER_LIST.add(new User(18, 123456L, "Y", "kapcb", "123456", LocalDateTime.now()));
        USER_LIST.add(new User(19, 223456L, "Y", "kapcb", "123456", LocalDateTime.now()));
        USER_LIST.add(new User(20, 323456L, "Y", "kapcb", "123456", LocalDateTime.now()));
        USER_LIST.add(new User(21, 423456L, "Y", "kapcb", "123456", LocalDateTime.now()));
        USER_LIST.add(new User(22, 523456L, "Y", "kapcb", "123456", LocalDateTime.now()));
        USER_LIST.add(new User(23, 623456L, "Y", "kapcb", "123456", LocalDateTime.now()));
    }
}
