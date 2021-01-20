package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.commons.constants.Constant;
import com.kapcb.ccc.service.IPermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a>Title: IPermissionServiceImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/20 21:32
 */
@Slf4j
@SuppressWarnings("serial")
@Service("permissionService")
public class IPermissionServiceImpl implements IPermissionService {

    private static final Map<String, Set<String>> permissionsMap = new HashMap<>(Constant.SIXTEEN.getInt());

    static {
        permissionsMap.put("kapcb", new HashSet<String>() {
            {
                add("get:userInfo");
                add("delete:userInfo");
                add("insert:userInfo");
            }
        });

        permissionsMap.put("eirc", new HashSet<String>() {
            {
                add("get:userInfo");
                add("update:userInfo");
            }
        });
    }

    @Override
    public Set<String> getPermissionByUsername(String username) {
        Set<String> permissionMap = permissionsMap.getOrDefault(username, new HashSet<>());
        log.warn("the permissions of username : " + username + " is : " + permissionMap);
        return permissionMap;
    }
}
