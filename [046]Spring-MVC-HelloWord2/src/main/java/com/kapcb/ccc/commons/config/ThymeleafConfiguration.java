package com.kapcb.ccc.commons.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import java.nio.charset.StandardCharsets;

/**
 * <a>Title: ThymeleafConfiguration </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/14 14:04
 */
@Configuration
public class ThymeleafConfiguration {

    private static final Logger log = LoggerFactory.getLogger(ThymeleafConfiguration.class);

    @Bean
    public SpringResourceTemplateResolver springResourceTemplateResolver() {
        log.warn("begin to load Spring Resource Template Resolver into Spring IOC Context...");
        SpringResourceTemplateResolver springResourceTemplateResolver = new SpringResourceTemplateResolver();
        springResourceTemplateResolver.setCacheable(false);
        springResourceTemplateResolver.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        springResourceTemplateResolver.setPrefix("/WEB-INF/template/");
        springResourceTemplateResolver.setSuffix(".html");
        springResourceTemplateResolver.setTemplateMode("HTML");
        log.warn("load Spring Resource Template Resolver into Spring IOC context success...");
        return springResourceTemplateResolver;
    }

    @Bean
    public SpringTemplateEngine springTemplateEngine(SpringResourceTemplateResolver springResourceTemplateResolver) {
        log.warn("begin to load Spring Template Engine to Spring IOC Context...");
        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
        springTemplateEngine.setTemplateResolver(springResourceTemplateResolver);
        log.warn("load Spring Template Engine into Spring IOC Context success...");
        return springTemplateEngine;
    }

    @Bean
    public ThymeleafViewResolver thymeleafViewResolver(SpringTemplateEngine springTemplateEngine) {
        log.warn("begin to load Thymeleaf View Resolver to Spring IOC Context...");
        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
        thymeleafViewResolver.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        thymeleafViewResolver.setTemplateEngine(springTemplateEngine);
        log.warn("load Thymeleaf View Resolver into Spring IOC Context success...");
        return thymeleafViewResolver;
    }
}
