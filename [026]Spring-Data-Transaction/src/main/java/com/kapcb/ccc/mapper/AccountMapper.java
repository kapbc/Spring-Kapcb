package com.kapcb.ccc.mapper;

import com.kapcb.ccc.domain.Account;

import java.math.BigDecimal;

/**
 * <a>Title: AccountMapper </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/10 11:19
 */
public interface AccountMapper {

    /**
     * get account balance
     *
     * @param userId   String userId
     * @param username String username
     * @return BigDecimal
     */
    BigDecimal getAccountBalance(String userId, String username);

    /**
     * get account info
     *
     * @param userId   String
     * @param username String
     * @return Account {@link Account}
     */
    Account getAccountInfo(String userId, String username);

    /**
     * transfer out from the account
     *
     * @param userId        String
     * @param username      String
     * @param transferMoney BigDecimal
     * @return boolean
     */
    boolean transferOutFromAccount(String userId, String username, BigDecimal transferMoney);

    /**
     * transfer in from the account
     *
     * @param userId     String
     * @param username   String
     * @param transferIn BigDecimal
     * @return boolean
     */
    boolean transferInFromAccount(String userId, String username, BigDecimal transferIn);
}
