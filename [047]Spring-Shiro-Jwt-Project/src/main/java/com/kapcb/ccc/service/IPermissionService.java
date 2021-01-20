package com.kapcb.ccc.service;


import java.util.Set;

/**
 * <a>Title: IPermissionService </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/20 21:31
 */
public interface IPermissionService {

    /**
     * get permissions by username
     *
     * @param username String
     * @return Set<String>
     */
    Set<String> getPermissionByUsername(String username);
}
