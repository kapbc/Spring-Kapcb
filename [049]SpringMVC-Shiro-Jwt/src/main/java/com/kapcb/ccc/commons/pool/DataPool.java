package com.kapcb.ccc.commons.pool;

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
public class DataPool {

    private DataPool() {
    }

    public static final Map<String, User> userMap = new HashMap<>(16);
    public static final Map<String, Set<String>> roleMap = new HashMap<>(16);
    public static final Map<String, Set<String>> permissionMap = new HashMap<>(16);

    static {

        /**
         * kapcb: admin and user
         * eirc: admin
         * ccc: user
         */
        userMap.put("kapcb", new User(123456L, "kapcb", "", "N", "eircccallroot@163.com", LocalDateTime.of(1997, 3, 11, 12, 59, 59)));
        userMap.put("eirc", new User(66666L, "eirc", "", "N", "eircccallroot@126.com", LocalDateTime.of(1997, 3, 11, 12, 59, 59)));
        userMap.put("ccc", new User(88888L, "ccc", "", "N", "eircccallroot@yeah.net", LocalDateTime.of(1997, 3, 11, 12, 59, 59)));


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
