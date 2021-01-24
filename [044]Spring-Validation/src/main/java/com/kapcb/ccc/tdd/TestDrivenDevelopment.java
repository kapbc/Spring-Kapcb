package com.kapcb.ccc.tdd;

import com.kapcb.ccc.commons.annotation.Verified;
import com.kapcb.ccc.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <a>Title: TestDrivenDevelopment </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/24 21:15
 */
public class TestDrivenDevelopment {

    public static void main(String[] args) {
//        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring/spring.xml");
        User user = new User();
        sys(user);
    }

    private static void sys(@Verified User user) {
        System.out.println(user.toString());
    }
}
