package com.kapcb.ccc.factory;

import com.kapcb.ccc.bean.AirPlane;

/**
 * <a>Title:AirPlaneInstanceFactory</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 * <p>
 * 实例工厂
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/5/31 10:23
 */
public class AirPlaneInstanceFactory {

    /**
     * 实例工厂
     * <p>
     * 需要先new AirPlaneInstanceFactory(); 对象
     * 然后在通过 AirPlaneInstanceFactory对象获取bean实例
     *
     * @param name 机长名
     * @return AirPlane飞机实例
     */
    public AirPlane getAirplane(String name) {
        System.out.println("实例工厂正在为你造飞机");
        AirPlane airPlane = new AirPlane();
        airPlane.setFdj("实例工厂的发动机");
        airPlane.setJzName(name);
        airPlane.setFjsName("实例工厂副机长");
        airPlane.setPersonNumber(50);
        airPlane.setYc("50m");
        return airPlane;
    }
}
