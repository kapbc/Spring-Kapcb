package com.kapcb.ccc.commons.config;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;


/**
 * <a>Title: ContextConfiguration </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/29-9:34
 */
@Configuration
@ComponentScan(basePackages = {"com.kapcb.ccc"})
public class ContextConfiguration {


    @Bean
    public PropertiesFactoryBean propertiesFactoryBean() {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        Resource resourceKapcb = new FileSystemResource("classpath:properties/kapcb.properties");
        Resource resourceSystem = new FileSystemResource("classpath:properties/system.properties");
        Resource[] location = new Resource[]{resourceKapcb, resourceSystem};
        propertiesFactoryBean.setLocations(location);
        return propertiesFactoryBean;
    }
}
