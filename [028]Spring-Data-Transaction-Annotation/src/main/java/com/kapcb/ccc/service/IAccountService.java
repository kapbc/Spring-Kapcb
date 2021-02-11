package com.kapcb.ccc.service;

import java.math.BigDecimal;

/**
 * <a>Title: IAccountService </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/11 12:42
 */
public interface IAccountService {

    /**
     * transfer balance from -> to
     *
     * @param fromUserId   String
     * @param fromUsername String
     * @param balanceOut   BigDecimal
     * @param toUserId     String
     * @param toUsername   String
     * @return boolean
     */
    boolean transferBalance(String fromUserId, String fromUsername, BigDecimal balanceOut, String toUserId, String toUsername);
}
