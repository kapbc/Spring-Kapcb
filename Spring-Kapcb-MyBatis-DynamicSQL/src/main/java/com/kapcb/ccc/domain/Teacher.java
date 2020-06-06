package com.kapcb.ccc.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * <a>Title:Teacher</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/5 19:53
 */
public class Teacher implements Serializable {
    private static final long serialVersionUID = 6903557717742001463L;


    private Integer id;
    private String name;
    private String className;
    private String address;
    private Date birth;

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
}
