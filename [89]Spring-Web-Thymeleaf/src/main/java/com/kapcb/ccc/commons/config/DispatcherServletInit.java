package com.kapcb.ccc.commons.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.ServletContext;

/**
 * <a>Title: DispatcherServletInit </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/20-15:05
 */
public class DispatcherServletInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    private static final String URL_PATTERN = "/";
    private static final String CHARACTER_ENCODING = "UTF-8";

    /**
     * 根容器，用于获取Spring应用容器的配置文件
     * 这个就是用来加载SpringContext的，类似于之前的spring.xml
     *
     * @return Class<?>[]
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{ApplicationContextConfiguration.class};
    }

    /**
     * Spring mvc容器，是根容器的子容器
     * 这个就是用来加载WebContext的，类似于之前的spring-mvc.xml
     *
     * @return Class<?>[]
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ApplicationWebConfiguration.class};
    }

    /**
     * "/"表示由DispatcherServlet处理所有向该应用发起的请求。
     * 这个是设置DispatcherServlet的映射路径
     *
     * @return String[]
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{URL_PATTERN};
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding(CHARACTER_ENCODING);
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[]{characterEncodingFilter,};
    }
}