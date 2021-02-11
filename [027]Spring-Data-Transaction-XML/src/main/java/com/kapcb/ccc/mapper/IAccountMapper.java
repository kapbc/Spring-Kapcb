package com.kapcb.ccc.mapper;

import java.math.BigDecimal;

/**
 * <a>Title: IAccountMapper </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/11 11:25
 */
public interface IAccountMapper {

    /**
     * transfer balance out
     *
     * @param userId      String
     * @param username    String
     * @param transferOut BigDecimal
     * @return boolean
     */
    boolean transferOutBalance(String userId, String username, BigDecimal transferOut);

    /**
     * transfer balance in
     *
     * @param userId     String
     * @param username   String
     * @param transferIn BigDecimal
     * @return boolean
     */
    boolean transferInBalance(String userId, String username, BigDecimal transferIn);
}
