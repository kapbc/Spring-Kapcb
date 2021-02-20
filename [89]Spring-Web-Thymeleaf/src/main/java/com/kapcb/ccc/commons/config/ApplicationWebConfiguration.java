package com.kapcb.ccc.commons.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import java.nio.charset.StandardCharsets;

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
@ComponentScan(basePackages = {"com.kapcb.ccc"})        //配置扫描的ctrl层
public class ApplicationWebConfiguration implements WebMvcConfigurer {


    /**
     * Spring 5 的静态资源解析器
     *
     * @return SpringResourceTemplateResolver
     */
    @Bean
    public SpringResourceTemplateResolver springResourceTemplateResolver() {
        SpringResourceTemplateResolver springResourceTemplateResolver = new SpringResourceTemplateResolver();
        springResourceTemplateResolver.setCacheable(false);
        springResourceTemplateResolver.setTemplateMode("HTML");
        springResourceTemplateResolver.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        springResourceTemplateResolver.setPrefix("/WEB-INF/template/");
        springResourceTemplateResolver.setSuffix(".html");
        return springResourceTemplateResolver;
    }

    /**
     * Spring 5 的模板引擎
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
     * Thymeleaf 的试图解析
     *
     * @param springTemplateEngine springTemplateEngine
     * @return ThymeleafViewResolver
     */
    @Bean
    public ThymeleafViewResolver thymeleafViewResolver(SpringTemplateEngine springTemplateEngine) {
        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
        thymeleafViewResolver.setTemplateEngine(springTemplateEngine);
        thymeleafViewResolver.setCharacterEncoding(StandardCharsets.UTF_8.toString());
        return thymeleafViewResolver;
    }

    /**
     * 配置静态资源的处理
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
