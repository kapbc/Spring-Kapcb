package com.kapcb.ccc.domain;

import java.util.Date;

/**
 * <a>Title: Teacher </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/28 11:01
 */
public class Teacher {

    private Integer id;
    private String name;
    private String className;
    private String address;
    private Date birth;

    public Teacher() {
    }

    public Teacher(Integer id, String name, String className, String address, Date birth) {
        this.id = id;
        this.name = name;
        this.className = className;
        this.address = address;
        this.birth = birth;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", className='" + className + '\'' +
                ", address='" + address + '\'' +
                ", birth=" + birth +
                '}';
    }
}
