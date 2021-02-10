package com.kapcb.ccc.mapper.impl;

import com.kapcb.ccc.domain.Account;
import com.kapcb.ccc.mapper.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
        sqlString.append(" FROM ").append(DB_USERNAME);
        sqlString.append(" WHERE ").append(DB_USERNAME).append(" = ");
        sqlString.append(username).append(" AND ").append(DB_ID).append(" = ").append(userId);
        System.out.println("the sql String is : " + sqlString.toString());
        Object result = jdbcTemplate.queryForObject(sqlString.toString(), new RowMapper() {
            @Override
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                return null;
            }
        });
        return ;
    }

    @Override
    public Account getAccountInfo(String userId, String username) {
        return null;
    }

    @Override
    public boolean transferOutFromAccount(String userId, String username, BigDecimal transferMoney) {
        return false;
    }

    @Override
    public boolean transferInFromAccount(String userId, String username, BigDecimal transferIn) {
        return false;
    }
}
