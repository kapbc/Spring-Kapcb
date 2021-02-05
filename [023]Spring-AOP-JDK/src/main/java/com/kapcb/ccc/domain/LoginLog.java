package com.kapcb.ccc.domain;

import java.time.LocalDateTime;

/**
 * <a>Title: LoginLog </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/5 22:49
 */
public class LoginLog {

    private String username;
    private LocalDateTime loginTime;

    public LoginLog() {
    }

    public LoginLog(String username, LocalDateTime loginTime) {
        this.username = username;
        this.loginTime = loginTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    @Override
    public String toString() {
        return "LoginLog{" +
                "username='" + username + '\'' +
                ", loginTime=" + loginTime +
                '}';
    }
}
