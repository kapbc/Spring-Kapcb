package com.kapcb.ccc;

import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <a>Title:Test</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/5/31 17:22
 */
@Scope(value = "")
public class Test {
    public static void main(String[] args) {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

        Object bookDao = ioc.getBean("bookDao");
        Object bookDao01 = ioc.getBean("bookDao");
        Object bookService = ioc.getBean("bookService");
        Object bookServlet = ioc.getBean("bookServlet");

        System.out.println("bookDao = " + bookDao);
        System.out.println(bookDao == bookDao01);
        System.out.println("bookService = " + bookService);
        System.out.println("bookServlet = " + bookServlet);

    }
}
