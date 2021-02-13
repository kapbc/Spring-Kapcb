package com.kapcb.ccc.commons.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * <a>Title: ContextConfigurationForXml </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/13 10:18
 */
@Configuration
@Import(value = {ContextConfiguration.class, ContextConfigurationForNest.class})
@ImportResource(value = "classpath:spring/spring.xml")
public class ContextConfigurationForXml {

    private static final Logger log = LoggerFactory.getLogger(ContextConfigurationForXml.class);

    public ContextConfigurationForXml() {
        log.warn("spring context configuration for xml is initial...");
    }
}
