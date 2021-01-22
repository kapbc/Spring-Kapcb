package com.kapcb.ccc.service;


import java.util.Set;

/**
 * <a>Title: IPermissionService </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/22-9:25
 */
public interface IPermissionService {

    /**
     * get permission by username
     *
     * @param username String
     * @return Set<Permission>
     */
    Set<String> getPermissionByUsername(String username);
}
