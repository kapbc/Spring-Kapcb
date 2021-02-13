package com.kapcb.ccc.commons.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <a>Title: ContextConfiguration </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/13 20:40
 */
@Configuration
@ComponentScan(basePackages = {"com.kapcb.ccc"})
public class SpringContextConfiguration {

    private static final Logger log = LoggerFactory.getLogger(SpringContextConfiguration.class);


}
