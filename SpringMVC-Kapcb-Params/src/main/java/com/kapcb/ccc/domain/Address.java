package com.kapcb.ccc.domain;

import java.io.Serializable;

/**
 * <a>Title:Address</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/6/8 11:54
 */
public class Address implements Serializable {
    private static final long serialVersionUID = -6163434464394357922L;

    /**
     * 省份
     */
    private String provinceName;
    /**
     * 城市
     */
    private String cityName;

    @Override
    public String toString() {
        return "Address{" +
                "provinceName='" + provinceName + '\'' +
                ", cityName='" + cityName + '\'' +
                '}';
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
}
