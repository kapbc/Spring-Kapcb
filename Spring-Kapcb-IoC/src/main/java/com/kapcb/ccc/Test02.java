package com.kapcb.ccc;

import com.kapcb.ccc.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <a>Title:Test02</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 * <p>
 * 根据Bean类型从IoC容器中获取Bean实例对象
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/5/30 18:39
 */
public class Test02 {

    public static void main(String[] args) {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");
        //根据Bean类型获取IoC中Bean的实例
/*        Person bean = ioc.getBean(Person.class);
        System.out.println("bean = " + bean);*/

        //根据id和类型同时指定获取IoC容器中Bean实例对象
        Person bean01 = ioc.getBean("person02", Person.class);
        System.out.println("bean1 = " + bean01);
    }
}
