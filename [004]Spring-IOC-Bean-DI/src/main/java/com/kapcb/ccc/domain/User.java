package com.kapcb.ccc.domain;


/**
 * <a>Title: User </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/30 22:11
 */
public class User {

    /**
     * 基本类型直接使用 property 标签,并且 property 可以自动进行类型转换
     */
    private int age;
    private Long userId;
    private String username;

    public User() {
        System.out.println("User is initial by no args constructor...");
    }

    public User(int age, Long userId, String username) {
        this.age = age;
        this.userId = userId;
        this.username = username;
        System.out.println("User is initial by all args constructor, the user's name is : " + username + "\n\n");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("transfer method setAge in User");
        this.age = age;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        System.out.println("transfer method setUserId in User");
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        System.out.println("transfer method setUsername in User");
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                '}';
    }
}
