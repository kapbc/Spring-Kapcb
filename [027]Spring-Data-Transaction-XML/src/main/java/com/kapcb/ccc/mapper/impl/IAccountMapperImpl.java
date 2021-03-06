package com.kapcb.ccc.mapper.impl;

import com.kapcb.ccc.mapper.IAccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * <a>Title: IAccountMapperImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/11 11:25
 */
@Repository(value = "accountMapper")
public class IAccountMapperImpl implements IAccountMapper {

    private static final String DB_USER_ID = "id";
    private static final String DB_BALANCE = "balance";
    private static final String DB_NAME = "tb_account";
    private static final String DB_USER_NAME = "username";

    @Autowired
    @Qualifier(value = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean transferOutBalance(String userId, String username, BigDecimal transferOut) {
        StringBuilder sqlString = new StringBuilder();
        sqlString.append("UPDATE ").append(DB_NAME);
        sqlString.append(" SET ").append(DB_BALANCE).append(" = ").append(DB_BALANCE);
        sqlString.append(" - ?").append(" WHERE ").append(DB_USER_ID).append(" = ?");
        sqlString.append(" AND ").append(DB_USER_NAME).append(" = ?");
        System.out.println("the sql string is : " + sqlString.toString());
        return jdbcTemplate.update(sqlString.toString(), transferOut, userId, username) == 1;
    }

    @Override
    public boolean transferInBalance(String userId, String username, BigDecimal transferIn) {
        StringBuilder sqlString = new StringBuilder();
        sqlString.append("UPDATE ").append(DB_NAME);
        sqlString.append(" SET ").append(DB_BALANCE).append(" = ").append(DB_BALANCE);
        sqlString.append(" + ?").append(" WHERE ").append(DB_USER_ID).append(" = ?");
        sqlString.append(" AND ").append(DB_USER_NAME).append(" = ?");
        System.out.println("the sql string is : " + sqlString.toString());
        return jdbcTemplate.update(sqlString.toString(), transferIn, userId, username) == 1;
    }
}
