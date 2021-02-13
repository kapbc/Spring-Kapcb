package com.kapcb.ccc.domain;

/**
 * <a>Title: User </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/13 9:52
 */
public class User {

    private String username;
    private String password;
    private String url;

    public void sayHello() {
        System.out.println("User sayHello");
    }

    public void start() {
        System.out.println("User Begin To Initial");
    }

    public void cleanUp() {
        System.out.println("User Destroy");
    }

    public User() {
    }

    public User(String username, String password, String url) {
        this.username = username;
        this.password = password;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
