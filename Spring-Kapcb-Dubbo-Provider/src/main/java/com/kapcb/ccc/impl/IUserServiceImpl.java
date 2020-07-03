package com.kapcb.ccc.impl;

import com.kapcb.ccc.domain.User;
import com.kapcb.ccc.service.IUserService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

/**
 * <a>Title:IUserServiceImpl</a>
 * <a>Author：<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/7/3 14:21
 */
public class IUserServiceImpl implements IUserService {

    public List<User> getAllUserList(String id) throws Exception {
        User user1 = new User(1, "kapcb", "test", "demo", new SimpleDateFormat("yyyy-MM-dd").parse("1997-03-11"));
        User user2 = new User(1, "ccc", "test", "demo", new SimpleDateFormat("yyyy-MM-dd").parse("1997-03-10"));

        return Arrays.asList(user1, user2);
    }
}
