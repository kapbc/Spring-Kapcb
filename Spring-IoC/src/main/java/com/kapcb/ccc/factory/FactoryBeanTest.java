package com.kapcb.ccc.factory;

import com.kapcb.ccc.bean.AirPlane;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <a>Title:FactoryBeanTest</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/5/31 10:37
 */
public class FactoryBeanTest {

    public static void main(String[] args) {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc3.xml");

        //静态工厂测试
        AirPlane airPlaneStatic = (AirPlane) ioc.getBean("airPlaneStatic");

        System.out.println("airPlaneStatic = " + airPlaneStatic);

        //实例工厂
        AirPlane airPlaneInstance = (AirPlane) ioc.getBean("airPlaneInstance");
        System.out.println("airPlaneInstance = " + airPlaneInstance);
    }
}
