package com.kapcb.ccc.domain;

/**
 * <a>Title: Car </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/31 21:47
 */
public class Car {

    private String carName;
    private String carNumber;
    private String calColor;

    public Car() {
    }

    public Car(String carName, String carNumber, String calColor) {
        this.carName = carName;
        this.carNumber = carNumber;
        this.calColor = calColor;
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

    public String getCalColor() {
        return calColor;
    }

    public void setCalColor(String calColor) {
        this.calColor = calColor;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carName='" + carName + '\'' +
                ", carNumber='" + carNumber + '\'' +
                ", calColor='" + calColor + '\'' +
                '}';
    }
}
