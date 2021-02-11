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

    boolean transferOutBalance(String userId, String username, BigDecimal transferOut);

    boolean transferInBalance(String userId, String username, BigDecimal transferIn);
}
