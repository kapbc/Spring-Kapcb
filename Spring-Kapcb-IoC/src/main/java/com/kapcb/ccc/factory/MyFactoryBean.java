package com.kapcb.ccc.factory;

import com.kapcb.ccc.bean.AirPlane;
import org.springframework.beans.factory.FactoryBean;

import java.util.UUID;

/**
 * <a>Title:MyFactoryBean</a>
 * <a>Author：ccc<a>
 * <a>Description：<a>
 * <p>
 * 自定义FactoryBean工厂
 * <p>
 * 1.编写一个FactoryBean的实现类
 * 2.在Spring配置文件中进行注册，Spring才会感知到
 *
 * @author ccc
 * @version 1.0.0
 * @date 2020/5/31 10:58
 */
public class MyFactoryBean implements FactoryBean<AirPlane> {

    /**
     * getObject:工厂方法
     *
     * @return AirPlane
     * @throws Exception Exception
     */
    public AirPlane getObject() throws Exception {
        System.out.println("myFactoryBean帮你创建对象");
        AirPlane airPlane = new AirPlane();
        airPlane.setJzName(UUID.randomUUID().toString());
        return airPlane;
    }

    /**
     * getObjectType:返回创建对象的类型
     * Spring自动调用方法来确认创建的对象是什么类型
     *
     * @return Class
     */
    public Class<?> getObjectType() {
        return AirPlane.class;
    }

    /**
     * isSingleton:是单例模式吗？
     * true 是单例 / false 不是单例
     *
     * @return boolean
     */
    public boolean isSingleton() {
        return false;
    }
}
