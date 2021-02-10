package com.kapcb.ccc.commons.config;

import com.kapcb.ccc.commons.utils.PropertiesUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.nio.charset.StandardCharsets;

/**
 * <a>Title: ContextConfiguration </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/8 17:11
 */
@Slf4j
@Configuration
public class ContextConfiguration {

    @Bean(value = "propertiesReader")
    public PropertiesFactoryBean propertiesFactoryBean() {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setIgnoreResourceNotFound(true);
        propertiesFactoryBean.setLocations(PropertiesUtil.getPropertiesResources());
        return propertiesFactoryBean;
    }

    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        propertySourcesPlaceholderConfigurer.setFileEncoding(StandardCharsets.UTF_8.toString());
        propertySourcesPlaceholderConfigurer.setIgnoreResourceNotFound(true);
        propertySourcesPlaceholderConfigurer.setIgnoreUnresolvablePlaceholders(true);
        propertySourcesPlaceholderConfigurer.setLocations(PropertiesUtil.getPropertiesResources());
        return propertySourcesPlaceholderConfigurer;
    }
}
