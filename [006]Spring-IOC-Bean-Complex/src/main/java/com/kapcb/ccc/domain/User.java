package com.kapcb.ccc.domain;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * <a>Title: User </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/30 23:44
 */
public class User {

    /**
     * 基本类型直接使用 property 标签,并且 property 可以自动进行类型转换
     */
    private Long userId;
    private boolean isVip;
    private String username;
    private String disadvantage;
    private Car drivenCar;
    private List<String> girlFriends;
    private Properties properties;
    private Map<String, String> houses;

    public User() {
        System.out.println("transfer no args constructor in User...");
    }

    public User(Long userId, boolean isVip, String username, String disadvantage, Car drivenCar, List<String> girlFriends, Properties properties, Map<String, String> houses) {
        this.userId = userId;
        this.isVip = isVip;
        this.username = username;
        this.disadvantage = disadvantage;
        this.drivenCar = drivenCar;
        this.girlFriends = girlFriends;
        this.properties = properties;
        this.houses = houses;
        System.out.println("transfer all args constructor , the user's name is : " + username + "\n\n");
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        System.out.println("transfer setUserId in user");
        this.userId = userId;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        System.out.println("transfer setVip in user");
        isVip = vip;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        System.out.println("transfer setUsername in user");
        this.username = username;
    }

    public String getDisadvantage() {
        return this.disadvantage;
    }

    public void setDisadvantage(String disadvantage) {
        System.out.println("transfer setDisadvantage in user");
        this.disadvantage = disadvantage;
    }

    public Car getDrivenCar() {
        return drivenCar;
    }

    public void setDrivenCar(Car drivenCar) {
        System.out.println("transfer setDrivenCar in user");
        this.drivenCar = drivenCar;
    }

    public List<String> getGirlFriends() {
        return girlFriends;
    }

    public void setGirlFriends(List<String> girlFriends) {
        System.out.println("transfer setGirlFriends in user");
        this.girlFriends = girlFriends;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        System.out.println("transfer setProperties in user");
        this.properties = properties;
    }

    public Map<String, String> getHouses() {
        return houses;
    }

    public void setHouses(Map<String, String> houses) {
        System.out.println("transfer setHouses in user");
        this.houses = houses;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", isVip=" + isVip +
                ", username='" + username + '\'' +
                ", disadvantage='" + disadvantage + '\'' +
                ", drivenCar=" + drivenCar +
                ", girlFriends=" + girlFriends +
                ", properties=" + properties +
                ", houses=" + houses +
                '}';
    }
}
