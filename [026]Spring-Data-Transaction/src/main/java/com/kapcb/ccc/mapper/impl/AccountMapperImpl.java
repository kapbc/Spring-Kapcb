package com.kapcb.ccc.mapper.impl;

import com.kapcb.ccc.domain.Account;
import com.kapcb.ccc.domain.Account.Builder;
import com.kapcb.ccc.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * <a>Title: AccountMapperImpl </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/10 11:19
 */
@Repository(value = "accountMapper")
public class AccountMapperImpl implements AccountMapper {

    private static final String DB_ID = "id";
    private static final String BD_NAME = "tb_account";
    private static final String DB_BALANCE = "balance";
    private static final String DB_USERNAME = "username";

    @Autowired
    @Qualifier(value = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;


    @Override
    public BigDecimal getAccountBalance(String userId, String username) {
        StringBuilder sqlString = new StringBuilder();
        sqlString.append("SELECT ").append(DB_BALANCE);
        sqlString.append(" FROM ").append(BD_NAME);
        sqlString.append(" WHERE ").append(DB_USERNAME).append(" = ");
        sqlString.append(username).append(" AND ").append(DB_ID).append(" = ").append(userId);
        System.out.println("the sql String is : " + sqlString.toString());
        BigDecimal balance = jdbcTemplate.queryForObject(sqlString.toString(), BigDecimal.class);
        return balance == null ? BigDecimal.valueOf(0) : balance;
    }

    @Override
    public Account getAccountInfo(String userId, String username) {
        StringBuilder sqlString = new StringBuilder();
        sqlString.append("SELECT ").append(DB_ID).append(DB_USERNAME).append(DB_BALANCE);
        sqlString.append(" FROM ").append(BD_NAME);
        sqlString.append(" WHERE ").append(DB_USERNAME).append(" = ");
        sqlString.append(username).append(" AND ").append(DB_ID).append(" = ").append(userId);
        System.out.println("the sql String is : " + sqlString.toString());
        return jdbcTemplate.queryForObject(sqlString.toString(), new RowMapper<Account>() {
            @Override
            public Account mapRow(ResultSet resultSet, int i) throws SQLException {
                Account account = new Builder()
                        .accountId(resultSet.getString(DB_ID))
                        .username(resultSet.getString(DB_USERNAME))
                        .balance(resultSet.getBigDecimal(DB_BALANCE))
                        .build();

                return account == null ? new Account() : account;
            }
        });
    }

    @Override
    public boolean transferOutFromAccount(String userId, String username, BigDecimal transferMoney) {
        BigDecimal accountBalance = this.getAccountBalance(userId, username);
        if (accountBalance.equals(BigDecimal.ZERO) || accountBalance.compareTo(transferMoney) < 0) {
            return false;
        }
        BigDecimal subtract = accountBalance.subtract(transferMoney);
        System.out.println("subtract = " + subtract);
        StringBuilder sqlString = new StringBuilder();
        sqlString.append("UPDATE ").append(BD_NAME);
        sqlString.append(" SET ").append(DB_BALANCE).append(" = ").append(subtract);
        sqlString.append(" WHERE ").append(DB_USERNAME).append(" = ").append(username);
        sqlString.append(" AND ").append(DB_ID).append(" = ").append(DB_ID);
        System.out.println("the sql String is : " + sqlString.toString());
        int update = jdbcTemplate.update(sqlString.toString());
        return update == 1;
    }

    @Override
    public boolean transferInFromAccount(String userId, String username, BigDecimal transferIn) {
        BigDecimal accountBalance = getAccountBalance(userId, username);
        BigDecimal add = accountBalance.add(transferIn);
        System.out.println("add = " + add);
        StringBuilder sqlString = new StringBuilder();
        sqlString.append("UPDATE ").append(BD_NAME);
        sqlString.append(" SET ").append(DB_BALANCE).append(" = ").append(add);
        sqlString.append(" WHERE ").append(DB_USERNAME).append(" = ").append(username);
        sqlString.append(" AND ").append(DB_ID).append(" = ").append(DB_ID);
        int update = jdbcTemplate.update(sqlString.toString());
        return update == 1;
    }
}
