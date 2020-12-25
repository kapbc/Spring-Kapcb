package com.kapcb.ccc.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * <a>Title:Person</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/5/30 17:24
 */
public class Person {

    /**
     * 基本类型直接使用 property 标签,并且 property 可以自动进行类型转换
     */
    private String lastName;
    private String gender;
    private String email;
    private Integer age;

    private Car car;
    private List<Book> books;
    private Map<String, Object> maps;
    private Properties properties;

    public Person() {
        System.out.println("person的无参构造器被调用");
    }

    public Person(String lastName, String gender, String email, Integer age, Car car, List<Book> books, Map<String, Object> maps, Properties properties) {
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.age = age;
        this.car = car;
        this.books = books;
        this.maps = maps;
        this.properties = properties;
        System.out.println("有参构造器被调用");
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", car=" + car +
                ", books=" + books +
                ", maps=" + maps +
                ", properties=" + properties +
                '}';
    }
}
