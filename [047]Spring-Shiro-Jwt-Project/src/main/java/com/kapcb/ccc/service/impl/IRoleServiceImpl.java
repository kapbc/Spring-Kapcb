package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.commons.constants.Constant;
import com.kapcb.ccc.service.IRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a>Title: IRoleServiceImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/20 21:21
 */
@Slf4j
@Service("roleService")
@SuppressWarnings("serial")
public class IRoleServiceImpl implements IRoleService {

    private static final Map<String, Set<String>> ROLE_MAP = new HashMap<>(Constant.SIXTEEN.getInt());

    static {
        ROLE_MAP.put("kapcb", new HashSet<String>() {
            {
                add("admin");
                add("author");
            }
        });

        ROLE_MAP.put("eirc", new HashSet<String>() {
            {
                add("user");
            }
        });
    }

    @Override
    public Set<String> getRolesByUsername(String username) {
        Set<String> roles = ROLE_MAP.getOrDefault(username, new HashSet<>());
        log.warn("the roles of the username " + username + " is : " + roles);
        return roles;
    }
}
