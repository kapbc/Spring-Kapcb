package com.kapcb.ccc.domain;

import java.io.Serializable;

/**
 * <a>Title:User</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/7 22:39
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1159926533414225220L;

    private String username;
    private String password;


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
}
