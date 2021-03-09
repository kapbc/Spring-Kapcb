package com.kapcb.ccc.application;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * <a>Title: ApplicationContext </a>
 * <a>Author: Mike Chen <a>
 * <a>Description：<a>
 *
 * @author Mike Chen
 * @date 2021/3/9-9:18
 */
public class MailApplicationContext implements ApplicationContextAware {

    private static ApplicationContext emailApplicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        MailApplicationContext.emailApplicationContext = applicationContext;
    }

    /**
     * 从静态变量 emailApplicationContext 中获得
     * @param beanName
     * @param <T>
     * @return
     */
    public static <T> T getBean(String beanName) {
        return (T) emailApplicationContext.getBean(beanName);
    }
}
