package com.kapcb.ccc.mapper;

import com.kapcb.ccc.commons.domain.User;
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
 * @date 2021/1/28 22:11
 */
@Slf4j
public class UserMapper {

    private UserMapper(){}

    public static final List<User> USER_LIST = new ArrayList<>();

    static {
        User kapcb = new User(1L, 18, "kapcb", "123456", LocalDateTime.now());
        User ccc = new User(2L, 19, "ccc", "123456", LocalDateTime.now());
        User eee = new User(3L, 120, "eee", "123456", LocalDateTime.now());
        USER_LIST.add(kapcb);
        USER_LIST.add(ccc);
        USER_LIST.add(eee);
    }

}
