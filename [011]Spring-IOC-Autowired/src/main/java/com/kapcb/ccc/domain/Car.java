package com.kapcb.ccc.domain;

import java.math.BigDecimal;

/**
 * <a>Title: Car </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/31 21:15
 */
public class Car {

    private String carName;
    private String carNumber;
    private BigDecimal carPrice;

    public Car() {
    }

    public Car(String carName, String carNumber, BigDecimal carPrice) {
        this.carName = carName;
        this.carNumber = carNumber;
        this.carPrice = carPrice;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public BigDecimal getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(BigDecimal carPrice) {
        this.carPrice = carPrice;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carName='" + carName + '\'' +
                ", carNumber='" + carNumber + '\'' +
                ", carPrice=" + carPrice +
                '}';
    }
}
