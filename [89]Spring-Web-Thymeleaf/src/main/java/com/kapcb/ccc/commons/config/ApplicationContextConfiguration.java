package com.kapcb.ccc.commons.config;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * <a>Title: ApplicationRootConfiguration </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/20-15:28
 */
@Configuration
@EnableScheduling       // 通过@EnableScheduling注解开启对计划任务的支持
/**
 * @EnableAspectJAutoProxy:开启AOP代理自动配置
 * proxyTargetClass=true:表示使用CGLib动态代理技术织入增强，决定是基于接口的还是基于类的代理被创建。默认为false（JDK代理）
 * 即<aop:aspectj-autoproxy proxy-target-class="true"/>
 */
@EnableAspectJAutoProxy(proxyTargetClass = true)    // 解决实现接口后，spring不能创建类实例的问题
@ComponentScan(basePackages = {"com.kapcb.ccc"},
        /**
         * 设置不扫描的文件，这里会排除springMVC扫描过的包
        */
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class))
/**
 * @EnableTransactionManagement 启用注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
 */
public class ApplicationContextConfiguration {


    /**
     * 这是一个Bean后置处理器，它会在所有拥有#Repository注解的类上添加一个通知器，这样就会捕获任何平台相关的异常并以
     * Spring非检查型访问异常的形式重新抛出。
     *
     * @return BeanPostProcessor
     */
    @Bean
    public BeanPostProcessor postProcessor() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
