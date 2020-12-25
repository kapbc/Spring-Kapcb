package com.kapcb.ccc.domain;

import org.springframework.stereotype.Component;

/**
 * <a>Title: User </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/25 - 17:28
 */
@Component
public class User {

    private String username;
    private String password;
    private String url;

    public void sayHello() {
        System.out.println("User sayHello");
    }

    public void start() {
        System.out.println("User Begin To Initial");
    }

    public void cleanUp() {
        System.out.println("User Destroy");
    }
}
