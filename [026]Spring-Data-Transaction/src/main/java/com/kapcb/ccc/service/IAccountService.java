package com.kapcb.ccc.service;

import java.math.BigDecimal;

/**
 * <a>Title: IAccountService </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/10 11:20
 */
public interface IAccountService {

    /**
     * transfer balance from to
     *
     * @param fromUserId         String
     * @param fromUsername       String
     * @param transferOutBalance BigDecimal
     * @param toUserId           String
     * @param toUsername         String
     * @param transferToBalance  BigDecimal
     * @return boolean
     */
    boolean transferBalance(String fromUserId, String fromUsername, BigDecimal transferOutBalance, String toUserId, String toUsername, BigDecimal transferToBalance);

}
