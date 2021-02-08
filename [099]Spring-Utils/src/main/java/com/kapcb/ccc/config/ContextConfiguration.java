package com.kapcb.ccc.config;

import com.kapcb.ccc.commons.utils.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
public class ContextConfiguration {

    private static final Logger log = LoggerFactory.getLogger(ContextConfiguration.class);

    @Bean(value = "propertiesReader")
    public PropertiesFactoryBean propertiesFactoryBean() {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        Resource[] propertiesResources = PropertiesUtil.getPropertiesResources();
        propertiesFactoryBean.setLocations(propertiesResources);
        return propertiesFactoryBean;
    }
}
