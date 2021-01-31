package com.kapcb.ccc.domain;

import java.time.LocalDateTime;

/**
 * <a>Title: User </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/31 13:19
 */
public class User {

    private Long userId;
    private String username;
    private LocalDateTime birthday;

    public void initMethod() {
        System.out.println("this is the init method in user");
    }

    public void destroyMethod() {
        System.out.println("this is the destroy method in user");
    }

    public User() {
    }

    public User(Long userId, String username, LocalDateTime birthday) {
        this.userId = userId;
        this.username = username;
        this.birthday = birthday;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
