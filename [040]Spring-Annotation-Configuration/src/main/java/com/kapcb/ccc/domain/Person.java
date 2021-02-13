package com.kapcb.ccc.domain;

import org.springframework.stereotype.Component;

/**
 * <a>Title: Person </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/13 10:15
 */
@Component
public class Person {

    private final String username;
    private final String email;

    public Person() {
        this.username = "kapcb";
        this.email = "eircccallroot@163.com";
    }

    public void eat() {
        System.out.println("Person eat rice...");
    }

    public void init() {
        System.out.println("Person Begin To Initial...");
    }

    public void destroy() {
        System.out.println("Person Begin To Destroy...");
    }
}
