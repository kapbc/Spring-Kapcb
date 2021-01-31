package com.kapcb.ccc.domain;

import java.time.LocalDateTime;
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
 * @date 2021/1/31 22:12
 */
public class User {

    private String username;
    private String email;
    private Long userId;
    private LocalDateTime birthday;
    private Map<String, Object> assets;
    private List<Car> carList;
    private Properties properties;
    private Company company;

    public User() {
    }

    public User(String username, String email, Long userId, LocalDateTime birthday, Map<String, Object> assets, List<Car> carList, Properties properties, Company company) {
        this.username = username;
        this.email = email;
        this.userId = userId;
        this.birthday = birthday;
        this.assets = assets;
        this.carList = carList;
        this.properties = properties;
        this.company = company;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public Map<String, Object> getAssets() {
        return assets;
    }

    public void setAssets(Map<String, Object> assets) {
        this.assets = assets;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", userId=" + userId +
                ", birthday=" + birthday +
                ", assets=" + assets +
                ", carList=" + carList +
                ", properties=" + properties +
                ", company=" + company +
                '}';
    }
}
