package com.kapcb.ccc.domain;

/**
 * <a>Title: User </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/31 21:11
 */
public class User {

    private Car car;
    private Long userId;
    private Integer age;
    private String username;

    public User() {
    }

    public User(Car car, Long userId, Integer age, String username) {
        this.car = car;
        this.userId = userId;
        this.age = age;
        this.username = username;
    }

    public Car getCar() {
        return this.car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "car=" + car +
                ", userId=" + userId +
                ", age=" + age +
                ", username='" + username + '\'' +
                '}';
    }
}
