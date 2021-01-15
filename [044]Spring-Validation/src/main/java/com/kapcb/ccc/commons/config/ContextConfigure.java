package com.kapcb.ccc.commons.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * <a>Title: ContextConfigure </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/15 23:58
 */
@Slf4j
@Component
@Configuration
public class ContextConfigure {

    private static final String SUFFIX = ".jsp";
    private static final String PREFIX = "/WEB-INF/page/";

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix(PREFIX);
        internalResourceViewResolver.setSuffix(SUFFIX);
        return internalResourceViewResolver;
    }
}
