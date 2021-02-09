package com.kapcb.ccc.commons.config;

import com.kapcb.ccc.commons.utils.PropertiesUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

    @Bean
    public PropertiesFactoryBean propertiesFactoryBean(){
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setIgnoreResourceNotFound(true);
        propertiesFactoryBean.setLocations(PropertiesUtil.getPropertiesResources());
        return propertiesFactoryBean;
    }

}
