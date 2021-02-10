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
    private BigDecimal balance;

    public Account() {
    }

    public Account(Builder builder) {
        this.accountId = builder.accountId;
        this.username = builder.username;
        this.balance = builder.balance;
    }

    public Account(String accountId, String username, BigDecimal balance) {
        this.accountId = accountId;
        this.username = username;
        this.balance = balance;
    }

    public static class Builder {
        private String accountId;
        private String username;
        private BigDecimal balance;

        public Account.Builder accountId(String accountId) {
            this.accountId = accountId;
            return this;
        }

        public Account.Builder username(String username) {
            this.username = username;
            return this;
        }

        public Account.Builder balance(BigDecimal balance) {
            this.balance = balance;
            return this;
        }

        public Account build() {
            return new Account(this);
        }
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

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", username='" + username + '\'' +
                ", money=" + balance +
                '}';
    }
}