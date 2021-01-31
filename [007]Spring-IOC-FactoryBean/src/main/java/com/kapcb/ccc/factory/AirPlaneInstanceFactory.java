package com.kapcb.ccc.factory;

import com.kapcb.ccc.domian.AirPlane;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <a>Title: AirPlaneInstanceFactory </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 * 实例工厂, 需要创建工厂本身才能获取需要创建的对象
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/31 12:02
 */
public class AirPlaneInstanceFactory {


    /**
     * 实例工厂创建对象的步骤
     * 1. 创建实例工厂本身 ==> AirPlaneInstanceFactory airPlaneInstanceFactory = new AirPlaneInstanceFactory()
     * 2. 调用对应的方法获取Bean实例对象 ==> airPlaneInstanceFactory.getAirPlane(String)
     *
     * 需要在配置文件中配置 {@see classpath:spring/spring.xml}
     *
     * @param planeName String
     * @return AirPlane
     */
    public AirPlane getAirPlane(String planeName) {
        System.out.println("Instance Factory...");
        AirPlane airPlane = new AirPlane();
        airPlane.setPlaneName(planeName);
        airPlane.setPlaneId(123456L);
        airPlane.setPlanePrice(BigDecimal.valueOf(1234567));
        airPlane.setPlaneCreateCompany("kapcb company");
        airPlane.setPlaneCreateDate(LocalDateTime.of(2021, 1, 31, 12, 7, 53, 53));
        return airPlane;
    }



}
