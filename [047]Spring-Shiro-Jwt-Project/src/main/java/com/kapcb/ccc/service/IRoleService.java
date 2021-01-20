package com.kapcb.ccc.service;

import com.kapcb.ccc.commons.domain.Role;

import java.util.Set;

/**
 * <a>Title: IRoleService </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/20 21:17
 */
public interface IRoleService {

    /**
     * get roles by user name
     *
     * @param username String
     * @return Set<String>
     */
    Set<String> getRolesByUsername(String username);
}
