package com.kapcb.ccc.domain;

/**
 * <a>Title: Bean </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/7 20:05
 */
public class Bean {

    /**
     * NoArgsConstructor
     * AllArgsConstructor
     * getter and setter
     * toString
     */
    private String username;
    private String email;
    private String address;
    private int age;

    public Bean() {
    }

    public Bean(String username, String email, String address, int age) {
        this.username = username;
        this.email = email;
        this.address = address;
        this.age = age;
    }

    public void sayHello() {
        System.out.println("Hello, I am " + this.username + ", this is my first Spring project. Thank you all!");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}
