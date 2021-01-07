package com.kapcb.ccc.factory;

import com.kapcb.ccc.bean.AirPlane;

/**
 * <a>Title:AirPlaneStaticFactory</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 * <p>
 * 静态工厂
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/5/31 10:24
 */
public class AirPlaneStaticFactory {

    /**
     * 静态工厂的实例创建
     * <p>
     * AirPlaneStaticFactory.getAirPlane(String name);就能获得工厂创建的bean对象
     *
     * @param name 机长名
     * @return AirPlane 飞机实例
     */
    public static AirPlane getAirPlane(String name) {
        System.out.println("静态工厂正在为你造飞机");
        AirPlane airPlane = new AirPlane();
        airPlane.setFdj("静态工厂的发动机");
        airPlane.setJzName(name);
        airPlane.setFjsName("静态工厂副机长");
        airPlane.setPersonNumber(50);
        airPlane.setYc("50m");
        return airPlane;
    }
}
