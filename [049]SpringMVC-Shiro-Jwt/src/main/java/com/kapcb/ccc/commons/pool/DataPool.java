package com.kapcb.ccc.commons.pool;

import com.kapcb.ccc.commons.constant.Constants;
import com.kapcb.ccc.commons.domain.User;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a>Title: DataPool </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/22-9:48
 */
@SuppressWarnings("serial")
public class DataPool {

    private DataPool() {
    }

    public static final Map<String, User> userMap = new HashMap<>(Constants.SIXTEEN.getInt());
    public static final Map<String, Set<String>> roleMap = new HashMap<>(Constants.SIXTEEN.getInt());
    public static final Map<String, Set<String>> permissionMap = new HashMap<>(Constants.SIXTEEN.getInt());

    static {

        /**
         * kapcb: admin and user
         * eirc: admin
         * ccc: user
         */
        userMap.put("kapcb", new User(123456L, "kapcb", "ed66cf5985a4b9d829dc59b9a53a67205b07fb7d", "N", "eircccallroot@163.com", LocalDateTime.of(1997, 3, 11, 12, 59, 59)));
        userMap.put("eirc", new User(66666L, "eirc", "62a16e43eeb70ad6b8b56874fa04055929390b19", "N", "eircccallroot@126.com", LocalDateTime.of(1997, 3, 11, 12, 59, 59)));
        userMap.put("ccc", new User(88888L, "ccc", "d2aecf87f5eb17e80d896d5125a5ea7cf0574f5b", "N", "eircccallroot@yeah.net", LocalDateTime.of(1997, 3, 11, 12, 59, 59)));
        userMap.put("ccc", new User(88888L, "ddd", "defb28d0372e674d71d097238af2fb5a3722be50", "Y", "eircccallroot@yeah.net", LocalDateTime.of(1997, 3, 11, 12, 59, 59)));


        roleMap.put("kapcb", new HashSet<String>() {
            {
                add("admin");
                add("user");
            }
        });

        roleMap.put("eirc", new HashSet<String>() {
            {
                add("admin");
            }
        });

        roleMap.put("ccc", new HashSet<String>() {
            {
                add("user");
            }
        });

        permissionMap.put("kapcb", new HashSet<String>() {
            {
                add("get:userInfo");
                add("delete:userInfo");
                add("update:userInfo");
                add("insert:userInfo");
            }
        });

        permissionMap.put("eirc", new HashSet<String>() {
            {
                add("get:userInfo");
                add("update:userInfo");
                add("insert:userInfo");
            }
        });

        permissionMap.put("ccc", new HashSet<String>() {
            {
                add("get:userInfo");
                add("update:userInfo");
            }
        });
    }
}
