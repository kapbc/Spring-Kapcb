package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.commons.pool.DataPool;
import com.kapcb.ccc.service.IRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * <a>Title: IRoleServiceImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/22-9:24
 */
@Slf4j
@Service(value = "roleService")
public class IRoleServiceImpl implements IRoleService {

    @Override
    public Set<String> getRoleByUsername(String username) {
        log.info("begin to process the get role by username");
        Set<String> rolesSet = DataPool.roleMap.getOrDefault(username, new HashSet<>());
        log.info("the roles of : " + username + " is : " + rolesSet);
        return rolesSet;
    }
}
