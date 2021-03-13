package com.kapcb.ccc.commons;

import ch.qos.logback.classic.servlet.LogbackServletContextListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.nio.charset.StandardCharsets;


/**
 * <a>Title: SystemWebApplicationInitializer </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/3/13 23:27
 */
@Slf4j
public class SystemWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        log.info("come into Start Up Method");
        AnnotationConfigWebApplicationContext annotationConfigWebApplicationContext = new AnnotationConfigWebApplicationContext();
        annotationConfigWebApplicationContext.register(ApplicationContextConfiguration.class);
        annotationConfigWebApplicationContext.register(ApplicationWebConfiguration.class);

        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding(StandardCharsets.UTF_8.toString());
        characterEncodingFilter.setForceEncoding(true);

        FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("characterEncodingFilter", characterEncodingFilter);
        encodingFilter.addMappingForUrlPatterns(null, true, "/*");

        LogbackServletContextListener logbackServletContextListener = new LogbackServletContextListener();
        servletContext.addListener(logbackServletContextListener);
        servletContext.setInitParameter("logbackConfigLocation", "classpath:logback-spring.xml");

        DispatcherServlet dispatcherServlet = new DispatcherServlet(annotationConfigWebApplicationContext);
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcherServlet", dispatcherServlet);

        annotationConfigWebApplicationContext.setServletContext(servletContext);
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
    }
}
