package com.kapcb.ccc.factory;

import com.kapcb.ccc.domian.AirPlane;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <a>Title: StaticInstanceFactory </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 * 静态工厂
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/31 12:02
 */
public class AirPlaneStaticInstanceFactory {

    private AirPlaneStaticInstanceFactory() {
    }

    /**
     * 静态工厂的实例创建
     * AirPlaneStaticInstanceFactory.getAirPlane(String)就能获得工厂创建的bean对象
     *
     * @param planeName String
     * @return AirPlane {@link AirPlane}
     */
    public static AirPlane getAirPlane(String planeName) {
        System.out.println("Static Instance Factory...");
        AirPlane airPlane = new AirPlane();
        airPlane.setPlaneId(1234L);
        airPlane.setPlaneName(planeName);
        airPlane.setPlanePrice(BigDecimal.valueOf(123456789));
        airPlane.setPlaneCreateCompany("kapcb's company");
        airPlane.setPlaneCreateDate(LocalDateTime.of(2021, 1, 31, 12, 50, 43, 53));
        return airPlane;
    }
}
