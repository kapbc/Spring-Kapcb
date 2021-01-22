package com.kapcb.ccc.service.impl;

import com.kapcb.ccc.commons.pool.DataPool;
import com.kapcb.ccc.service.IPermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * <a>Title: IPermissionServiceImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/22-9:25
 */
@Slf4j
@Service(value = "permissionService")
public class IPermissionServiceImpl implements IPermissionService {

    @Override
    public Set<String> getPermissionByUsername(String username) {
        log.info("begin to process the get permission by username");
        Set<String> permissionSet = DataPool.permissionMap.getOrDefault(username, new HashSet<>());
        log.info("the permissions of " + username + " is : " + permissionSet);
        return permissionSet;
    }
}
