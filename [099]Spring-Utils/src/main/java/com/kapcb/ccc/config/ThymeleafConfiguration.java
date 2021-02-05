package com.kapcb.ccc.commons.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring5.SpringWebFluxTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

/**
 * <a>Title: ThymeleafConfiguration </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/29-13:39
 */
@Configuration
public class ThymeleafConfiguration {


    @Bean
    public SpringResourceTemplateResolver springResourceTemplateResolver() {
        SpringResourceTemplateResolver springResourceTemplateResolver = new SpringResourceTemplateResolver();
        springResourceTemplateResolver.setCacheable(false);
        springResourceTemplateResolver.setSuffix("/WEB-INF/template/");
        springResourceTemplateResolver.setPrefix(".html");
        springResourceTemplateResolver.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        Set<String> templateMode = new HashSet<>();
        templateMode.add("HTML");
        springResourceTemplateResolver.setHtmlTemplateModePatterns(templateMode);
        return springResourceTemplateResolver;
    }

    @Bean
    public SpringWebFluxTemplateEngine springTemplateEngine() {
        SpringWebFluxTemplateEngine templateEngine = new SpringWebFluxTemplateEngine();
        templateEngine.setTemplateResolver(springResourceTemplateResolver());
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
        thymeleafViewResolver.setTemplateEngine(springTemplateEngine());
        thymeleafViewResolver.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        return thymeleafViewResolver;
    }
}
