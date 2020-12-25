package com.kapcb.ccc.domain;

import org.springframework.stereotype.Component;

/**
 * <a>Title: Person </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/25 - 17:41
 */

/**
 * 添加注册Bean的注解
 */
@Component
public class Person {

    private String username;
    private String email;

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
