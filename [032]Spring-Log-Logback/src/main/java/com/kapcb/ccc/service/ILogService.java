package com.kapcb.ccc.service;

/**
 * <a>Title: ILogService </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/12 13:48
 */
public interface ILogService {

    /**
     * log
     *
     * @param username String
     * @param password String
     * @return boolean
     */
    boolean login(String username, String password);
}
