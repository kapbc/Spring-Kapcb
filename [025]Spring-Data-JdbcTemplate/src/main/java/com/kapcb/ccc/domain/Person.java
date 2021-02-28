package com.kapcb.ccc.domain;

import com.kapcb.ccc.annotation.Column;

import java.time.LocalDateTime;

/**
 * <a>Title: Person </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/28 11:34
 */
public class Person {

    @Column(name = "id")
    private Long userId;

    @Column(name = "username")
    private String username;

    @Column(name = "loginname")
    private String loginName;

    @Column(name = "address")
    private String address;

    @Column(name = "sex")
    private Integer sex;

    @Column(name = "remark")
    private String remark;

    @Column(name = "password")
    private String password;

    @Column(name = "deptId")
    private Integer deptId;

    @Column(name = "hiredate")
    private LocalDateTime hireDate;

    @Column(name = "mgr")
    private Integer mgr;

    @Column(name = "available")
    private Integer available;

    @Column(name = "orderNum")
    private Integer orderNumber;

    @Column(name = "type")
    private Integer type;

    @Column(name = "imagePath")
    private String imagePath;

    @Column(name = "salt")
    private String salt;

    public Person() {
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

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public LocalDateTime getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDateTime hireDate) {
        this.hireDate = hireDate;
    }

    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "Person{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", loginName='" + loginName + '\'' +
                ", address='" + address + '\'' +
                ", sex=" + sex +
                ", remark='" + remark + '\'' +
                ", password='" + password + '\'' +
                ", deptId=" + deptId +
                ", hireDate=" + hireDate +
                ", mgr=" + mgr +
                ", available=" + available +
                ", orderNumber=" + orderNumber +
                ", type=" + type +
                ", imagePath='" + imagePath + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }
}
