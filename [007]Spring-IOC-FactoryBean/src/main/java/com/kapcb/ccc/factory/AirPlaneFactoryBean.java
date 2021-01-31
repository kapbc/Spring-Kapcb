package com.kapcb.ccc.factory;

import com.kapcb.ccc.domian.AirPlane;
import org.springframework.beans.factory.FactoryBean;

import java.util.UUID;

/**
 * <a>Title: AirPlaneFactroyBean </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 * <p>
 * 自定义FactoryBean工厂
 * 1.编写一个FactoryBean的实现类
 * 2.在Spring配置文件中进行注册，Spring才会感知到
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/31 11:52
 */
public class AirPlaneFactoryBean implements FactoryBean<AirPlane> {

    /**
     * 工厂方法 Spring创建对象
     * 定义返回Bean的类型, FactoryBean可以返回与定义类型不一样的Bean
     * 这里向Spring中声明的Bean为AirPlaneFactoryBean, 但是实际返回的Bean为AirPlane
     * 隐藏Spring创建对象的细节
     *
     * @return AirPlane
     * @throws Exception Exception
     */
    @Override
    public AirPlane getObject() throws Exception {
        System.out.println("Spring Factory Bean Help Create New Instance");
        AirPlane airPlane = new AirPlane();
        airPlane.setPlaneName(UUID.randomUUID().toString().substring(0, 5));
        return airPlane;
    }

    /**
     * getObjectType:返回创建对象的类型
     * Spring自动调用方法来确认创建的对象是什么类型
     *
     * @return Class
     */
    @Override
    public Class<?> getObjectType() {
        return AirPlane.class;
    }

    /**
     * isSingleton: Spring创建的对象是否为单例
     * true 是单例 / false 不是单例
     *
     * @return boolean
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
