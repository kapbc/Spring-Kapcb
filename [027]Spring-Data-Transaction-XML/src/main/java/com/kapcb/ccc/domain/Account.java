package com.kapcb.ccc.domain;

import java.math.BigDecimal;

/**
 * <a>Title: Account </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/11 11:19
 */
public class Account {

    private String userId;
    private String username;
    private BigDecimal balance;

    public Account() {
    }

    public Account(Builder builder) {
        this.userId = builder.userId;
        this.username = builder.username;
        this.balance = builder.balance;
    }

    public static class Builder {
        private String userId;
        private String username;
        private BigDecimal balance;

        public Builder() {
        }

        public Account.Builder userId(String userId) {
            this.userId = userId;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
}
