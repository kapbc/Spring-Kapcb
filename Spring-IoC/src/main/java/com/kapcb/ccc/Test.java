package com.kapcb.ccc;

import com.kapcb.ccc.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <a>Title:Test</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/5/30 17:36
 */
public class Test {

    public static void main(String[] args) {
        /**
         * 从容器中获取注册的组件
         *  ApplicationContext：接口代表ioc容器
         *  ClassPathXmlApplicationContext：代表当前引用的xml配置文件在ClassPath类路径下
         *  根据Spring的配置文件得到IoC容器对象
         */
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");
        Person bean = (Person) ioc.getBean("person01");
        Person bean01 = (Person) ioc.getBean("person01");
        System.out.println(bean);
        System.out.println(bean == bean01);//true
    }
}
