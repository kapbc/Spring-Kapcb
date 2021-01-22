package com.kapcb.ccc.commons.pool;

import com.kapcb.ccc.commons.domain.Permission;
import com.kapcb.ccc.commons.domain.Role;
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

    private static final Map<String, User> userMap = new HashMap<>(16);
    private static final Map<String, Set<Role>> roleMap = new HashMap<>(16);
    private static final Map<String, Set<Permission>> permissionMap = new HashMap<>(16);

    static {

        /**
         * kapcb: admin and user
         * eirc: admin
         * ccc: user
         */
        userMap.put("kapcb", new User("kapcb", "", "N", "eircccallroot@163.com", LocalDateTime.of(1997, 3, 11, 12, 59, 59)));
        userMap.put("eirc", new User("eirc", "", "N", "eircccallroot@126.com", LocalDateTime.of(1997, 3, 11, 12, 59, 59)));
        userMap.put("ccc", new User("ccc", "", "N", "eircccallroot@yeah.net", LocalDateTime.of(1997, 3, 11, 12, 59, 59)));


        roleMap.put("kapcb", new HashSet<Role>() {
            {
                add(new Role("kapcb", "admin"));
                add(new Role("kapcb", "user"));
            }
        });

        roleMap.put("eirc", new HashSet<Role>() {
            {
                add(new Role("eirc", "admin"));
            }
        });

        roleMap.put("ccc", new HashSet<Role>() {
            {
                add(new Role("ccc", "user"));
            }
        });

        permissionMap.put("kapcb", new HashSet<Permission>() {
            {
                add(new Permission("kapcb", "get:userInfo"));
                add(new Permission("kapcb", "delete:userInfo"));
                add(new Permission("kapcb", "update:userInfo"));
                add(new Permission("kapcb", "insert:userInfo"));
            }
        });

        permissionMap.put("eirc", new HashSet<Permission>() {
            {
                add(new Permission("eirc", "get:userInfo"));
                add(new Permission("eirc", "update:userInfo"));
                add(new Permission("eirc", "insert:userInfo"));
            }
        });

        permissionMap.put("ccc", new HashSet<Permission>() {
            {
                add(new Permission("ccc", "get:userInfo"));
                add(new Permission("ccc", "update:userInfo"));
            }
        });
    }
}
