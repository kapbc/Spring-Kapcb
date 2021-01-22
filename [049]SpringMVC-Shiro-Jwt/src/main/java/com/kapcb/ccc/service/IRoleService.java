package com.kapcb.ccc.service;


import java.util.Set;

/**
 * <a>Title: IRoleService </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/22-9:24
 */
public interface IRoleService {

    /**
     * get roles by username
     *
     * @param username String
     * @return Set<Role>
     */
    Set<String> getRoleByUsername(String username);
}
