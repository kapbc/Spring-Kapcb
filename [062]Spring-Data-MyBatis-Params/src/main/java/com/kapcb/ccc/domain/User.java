package com.kapcb.ccc.domain;

/**
 * <a>Title: User </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/28 10:33
 */
public class User{

    private Integer id;
    private String username;
    private String gender;
    private String email;
    private String loginAccount;

    public User() {
    }

    public User(Integer id, String username, String gender, String email, String loginAccount) {
        this.id = id;
        this.username = username;
        this.gender = gender;
        this.email = email;
        this.loginAccount = loginAccount;
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

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", loginAccount='" + loginAccount + '\'' +
                '}';
    }
}
