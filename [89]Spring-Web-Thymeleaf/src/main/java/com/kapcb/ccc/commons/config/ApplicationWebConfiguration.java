package com.kapcb.ccc.commons.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;


/**
 * <a>Title: ApplicationWebConfiguration </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/20-15:15
 */
@EnableWebMvc       //启用Spring MVC组件
@Configuration      //配置类
@ComponentScan(basePackages = {"com.kapcb.ccc"},
        includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {Controller.class, ControllerAdvice.class}))     //配置包扫描
public class ApplicationWebConfiguration implements WebMvcConfigurer {


    private static final String TEMPLATE_MODE = "HTML";
    private static final String TEMPLATE_SUFFIX = ".html";
    private static final String TEMPLATE_CHARACTER_ENCODING = "UTF-8";
    private static final String TEMPLATE_PREFIX = "/WEB-INF/template/";

    /**
     * Spring 5 的静态资源解析器
     *
     * @return SpringResourceTemplateResolver
     */
    @Bean
    public SpringResourceTemplateResolver springResourceTemplateResolver() {
        SpringResourceTemplateResolver springResourceTemplateResolver = new SpringResourceTemplateResolver();
        springResourceTemplateResolver.setCacheable(false);
        springResourceTemplateResolver.setPrefix(TEMPLATE_PREFIX);
        springResourceTemplateResolver.setSuffix(TEMPLATE_SUFFIX);
        springResourceTemplateResolver.setTemplateMode(TEMPLATE_MODE);
        springResourceTemplateResolver.setCharacterEncoding(TEMPLATE_CHARACTER_ENCODING);
        return springResourceTemplateResolver;
    }

    /**
     * Spring 5 模板引擎
     *
     * @param springResourceTemplateResolver SpringResourceTemplateResolver
     * @return SpringTemplateEngine
     */
    @Bean
    public SpringTemplateEngine springTemplateEngine(SpringResourceTemplateResolver springResourceTemplateResolver) {
        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
        springTemplateEngine.setTemplateResolver(springResourceTemplateResolver);
        return springTemplateEngine;
    }

    /**
     * Thymeleaf 视图解析
     *
     * @param springTemplateEngine springTemplateEngine
     * @return ThymeleafViewResolver
     */
    @Bean
    public ThymeleafViewResolver thymeleafViewResolver(SpringTemplateEngine springTemplateEngine) {
        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
        thymeleafViewResolver.setTemplateEngine(springTemplateEngine);
        thymeleafViewResolver.setCharacterEncoding(TEMPLATE_CHARACTER_ENCODING);
        return thymeleafViewResolver;
    }

    /**
     * 配置静态资源的处理
     * 对静态资源的请求转发到容器缺省的servlet，而不使用DispatcherServlet
     * @param defaultServletHandlerConfigurer DefaultServletHandlerConfigurer
     */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer defaultServletHandlerConfigurer) {
        /**
         * 把针对静态资源的请求转交给servlert容器的default servlet处理
         */
        defaultServletHandlerConfigurer.enable();
    }


}