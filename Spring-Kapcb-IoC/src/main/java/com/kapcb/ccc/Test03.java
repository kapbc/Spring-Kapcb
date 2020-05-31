package com.kapcb.ccc;

import com.kapcb.ccc.bean.Book;
import com.kapcb.ccc.bean.Car;
import com.kapcb.ccc.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * <a>Title:Test03</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 * <p>
 * 正确的为各种属性赋值
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/5/30 19:56
 */
public class Test03 {

    public static void main(String[] args) {

        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc2.xml");

        Person person01 = (Person) ioc.getBean("person01");

        Person person02 = (Person) ioc.getBean("person02");

        Person person03 = (Person) ioc.getBean("person03");

        Person person04 = (Person) ioc.getBean("person04");

        Person person05 = (Person) ioc.getBean("person05");

        Person person06 = (Person) ioc.getBean("person06");

//        Person person07 = (Person) ioc.getBean("person07");

        Person person08 = (Person) ioc.getBean("person08");

        //引用
        System.out.println("引用 " + person01.getCar());

        //为 list 赋值
        System.out.println("为 list 赋值===================================");
        List<Book> books = person02.getBooks();
        System.out.println(books);

        // map
        System.out.println("map===================================");
        Map<String, Object> maps = person03.getMaps();
        System.out.println("maps = " + maps);

        //properties
        System.out.println("properties===================================");
        Properties properties = person04.getProperties();
        System.out.println("properties = " + properties);

        //util名称空间
        System.out.println("util名称空间===================================");
        Map<String, Object> maps1 = person05.getMaps();
        System.out.println("maps1 = " + maps1);

        //级联属性赋值
        System.out.println("级联属性赋值===================================");
        Car car = person06.getCar();
        System.out.println("car = " + car);

//        System.out.println(person07);
        System.out.println(person08);
    }

}
