package com.kapcb.ccc.domain;

import java.io.Serializable;

/**
 * <a>Title: Address </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/14 15:03
 */
public class Address implements Serializable {

    private static final long serialVersionUID = 7203577180598080914L;
    /**
     * 省份
     */
    private String provinceName;
    /**
     * 城市
     */
    private String cityName;

    public Address() {
    }

    public Address(String provinceName, String cityName) {
        this.provinceName = provinceName;
        this.cityName = cityName;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "Address{" +
                "provinceName='" + provinceName + '\'' +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
