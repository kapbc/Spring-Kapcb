package com.kapcb.ccc.domain;

/**
 * <a>Title: Car </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/31 22:13
 */
public class Car {

    private String carName;
    private String carNumber;
    private String carColor;

    public Car() {
    }

    public Car(String carName, String carNumber, String carColor) {
        this.carName = carName;
        this.carNumber = carNumber;
        this.carColor = carColor;
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

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carName='" + carName + '\'' +
                ", carNumber='" + carNumber + '\'' +
                ", carColor='" + carColor + '\'' +
                '}';
    }
}
