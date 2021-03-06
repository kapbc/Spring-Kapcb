package com.kapcb.ccc.domain;

/**
 * <a>Title: KpacbDataSource </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/13 20:52
 */
public class KpacbDataSource {

    private String username;
    private String password;

    public KpacbDataSource() {
    }

    public KpacbDataSource(String username, String password) {
        this.username = username;
        this.password = password;
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

    @Override
    public String toString() {
        return "KpacbDataSource{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
