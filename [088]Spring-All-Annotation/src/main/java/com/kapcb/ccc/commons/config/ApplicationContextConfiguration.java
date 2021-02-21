package com.kapcb.ccc.commons.config;

import ch.qos.logback.classic.servlet.LogbackServletContextListener;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRegistration.Dynamic;
import java.util.Set;

/**
 * <a>Title: ApplicationContextConfiguration </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/21 13:26
 */
public class ApplicationContextConfiguration implements WebApplicationInitializer {

    /**
     * <groupId>javax.servlet</groupId>
     * <artifactId>javax.servlet-api</artifactId>
     * <version>4.0.1</version>
     *
     * @param servletContext ServletContext
     * @throws ServletException ServletException
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        /**
         * 注解配置的SpringContext
         */
        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        webApplicationContext.register(ApplicationContextConfiguration.class);
        webApplicationContext.setServletContext(servletContext);

        /**
         * 创建dispatcherServlet
         */
        Dynamic dispatcherServlet = servletContext.addServlet("dispatcherServlet", new DispatcherServlet(webApplicationContext));

        /**
         * 添加上下文路径地址
         */
        dispatcherServlet.addMapping("/");

        /**
         * 最优先启动
         */
        dispatcherServlet.setLoadOnStartup(1);
    }
}
