package com.kapcb.ccc.domain;

/**
 * <a>Title: Car </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/30 23:44
 */
public class Car {

    private String carName;
    private String carColor;
    private String carNumber;

    public Car() {
    }

    public Car(String carName, String carColor, String carNumber) {
        this.carName = carName;
        this.carColor = carColor;
        this.carNumber = carNumber;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carName='" + carName + '\'' +
                ", carColor='" + carColor + '\'' +
                ", carNumber='" + carNumber + '\'' +
                '}';
    }
}
