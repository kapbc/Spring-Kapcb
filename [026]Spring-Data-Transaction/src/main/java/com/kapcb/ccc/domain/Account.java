package com.kapcb.ccc.domain;

import java.math.BigDecimal;

/**
 * <a>Title: Account </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/10 11:05
 */
public class Account {

    private String accountId;
    private String username;
    private BigDecimal money;

    public Account() {
    }

    public Account(String accountId, String username, BigDecimal money) {
        this.accountId = accountId;
        this.username = username;
        this.money = money;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", username='" + username + '\'' +
                ", money=" + money +
                '}';
    }
}
