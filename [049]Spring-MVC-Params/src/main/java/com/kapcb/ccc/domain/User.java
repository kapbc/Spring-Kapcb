package com.kapcb.ccc.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <a>Title: User </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/14 15:06
 */
public class User implements Serializable {

    private static final long serialVersionUID = -2825452189843378326L;

    private String username;
    private String password;
    private Integer age;
    private List<Account> accounts;
    private Map<String, Account> accountMap;

    public User() {
    }

    public User(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
        this.age = builder.age;
        this.accounts = builder.accounts;
        this.accountMap = builder.accountMap;
    }

    public static class Builder {

        private String username;
        private String password;
        private Integer age;
        private List<Account> accounts;
        private Map<String, Account> accountMap;

        public Builder() {
        }

        public User.Builder username(String username) {
            this.username = username;
            return this;
        }

        public User.Builder password(String password) {
            this.password = password;
            return this;
        }

        public User.Builder age(Integer age) {
            this.age = age;
            return this;
        }

        public User.Builder account(List<Account> accounts) {
            this.accounts = accounts;
            return this;
        }

        public User.Builder accountMap(Map<String, Account> accountMap) {
            this.accountMap = accountMap;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Map<String, Account> getAccountMap() {
        return accountMap;
    }

    public void setAccountMap(Map<String, Account> accountMap) {
        this.accountMap = accountMap;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", accounts=" + accounts +
                ", accountMap=" + accountMap +
                '}';
    }
}
