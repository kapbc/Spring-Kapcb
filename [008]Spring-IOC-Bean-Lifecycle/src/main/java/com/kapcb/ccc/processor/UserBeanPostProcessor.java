package com.kapcb.ccc.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * <a>Title: UserBeanPostProcessor </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 * <p>
 * 1.后置处理器实现类
 * 2.注册到容器中
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/31 13:22
 */
public class UserBeanPostProcessor implements BeanPostProcessor {

    /**
     * postProcessBeforeInitialization 初始化之前调用
     *
     * @param bean     将要初始化的bean
     * @param beanName 将要初始化的bean的名称
     * @return 传入的bean
     * @throws BeansException BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("[" + beanName + "] bean will transfer initial method postProcessBeforeInitialization, this bean is : [" + bean + "]");
        return bean;
    }

    /**
     * postProcessAfterInitialization 初始化之后调用
     *
     * @param bean     初始化的bean
     * @param beanName 在xml配置文件中配置的id标识
     * @return Object
     * @throws BeansException BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("[" + beanName + "] bean create finished postProcessAfterInitialization, this bean is : [" + bean + "]");
        return bean;
    }
}
