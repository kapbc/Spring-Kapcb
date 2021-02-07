package com.kapcb.ccc.domain;

import java.time.LocalDateTime;

/**
 * <a>Title: User </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/6 17:16
 */
public class User {

    private Long userId;
    private String username;
    private String password;
    private String phone;
    private String email;
    private LocalDateTime created;
    private LocalDateTime updated;

    public User() {
    }

    public User(Builder builder) {
        this.userId = builder.userId;
        this.username = builder.username;
        this.password = builder.password;
        this.phone = builder.phone;
        this.email = builder.email;
        this.created = builder.created;
        this.updated = builder.updated;
    }

    public static class Builder {

        private Long userId;
        private String username;
        private String password;
        private String phone;
        private String email;
        private LocalDateTime created;
        private LocalDateTime updated;

        public Builder() {
        }

        public User.Builder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        public User.Builder username(String username) {
            this.username = username;
            return this;
        }

        public User.Builder password(String password) {
            this.password = password;
            return this;
        }

        public User.Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public User.Builder email(String email) {
            this.email = email;
            return this;
        }

        public User.Builder created(LocalDateTime created) {
            this.created = created;
            return this;
        }

        public User.Builder updated(LocalDateTime updated) {
            this.updated = updated;
            return this;
        }

        public User builder() {
            return new User(this);
        }


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
