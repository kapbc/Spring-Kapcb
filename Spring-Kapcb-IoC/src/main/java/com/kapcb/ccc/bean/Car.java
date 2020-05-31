package com.kapcb.ccc.bean;

/**
 * <a>Title:Car</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/5/30 19:48
 */
public class Car {

    private String carName;
    private String price;
    private String color;

    public Car(){
        System.out.println("Car的无参构造器被调用");
    }

    public Car(String carName, String price, String color) {
        this.carName = carName;
        this.price = price;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carName='" + carName + '\'' +
                ", price='" + price + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
