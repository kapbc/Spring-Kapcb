package com.kapcb.ccc.domain;

import java.io.Serializable;

/**
 * <a>Title:User</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/2 20:59
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1159926533414225220L;

    private Integer id;
    private String username;
    private String gender;
    private String email;

    public User() {

    }

    public User(Integer id, String username, String gender, String email) {
        this.id = id;
        this.username = username;
        this.gender = gender;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
