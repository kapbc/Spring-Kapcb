package com.kapcb.ccc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <a>Title:Test04</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/5/30 22:01
 */
public class Test04 {

    public static void main(String[] args) {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc3.xml");
    }

}
