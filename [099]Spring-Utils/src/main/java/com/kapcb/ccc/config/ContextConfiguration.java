package com.kapcb.ccc.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * <a>Title: ContextConfiguration </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/1/29-9:34
 */
@Configuration
public class ContextConfiguration {

    private static final Logger log = LoggerFactory.getLogger(ContextConfiguration.class);

    private static final String systemPropertiesFile = "system.properties";
    private static final String kapcbPropertiesFile = "kapcb.properties";
    private static final String path = "src/main/resources/properties/";
    private static final List<String> propertiesList = new ArrayList<>();
    private static final Resource[] resources = new Resource[]{};

    static {
        propertiesList.add(systemPropertiesFile);
        propertiesList.add(kapcbPropertiesFile);
    }

    @Bean(value = "propertiesReader")
    public PropertiesFactoryBean propertiesFactoryBean() {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        Resource resourceSystem = null;
        Resource resourceKapcb = null;
        try {
            URL classPath = ContextConfiguration.class.getClassLoader().getResource("");
            /**
             * file:/D:/develop/IDE-WorkSpace/Spring-Thymeleaf/out/production/Spring-Thymeleaf/
             */
            log.warn("the class path is : " + classPath);
            String propertiesFileClasspath = classPath.toString();
            log.warn("the class path is : " + propertiesFileClasspath);
            /**
             * 移除开头的 file:
             */
            propertiesFileClasspath = propertiesFileClasspath.substring(6);

            log.warn("the subtring path is : " + propertiesFileClasspath);
            /**
             * 如果为window系统下,则把路径中的路径分隔符替换为window系统的文件路径分隔符
             */
            propertiesFileClasspath = propertiesFileClasspath.replaceAll("/", File.separator);
            /**
             * 兼容处理最后一个字符是否为 window系统的文件路径分隔符,同时建立 properties 文件路径
             * 例如返回: D:\workspace\myproject01\WEB-INF\classes\config.properties
             */
            log.warn("the subtring path is : " + propertiesFileClasspath);
            for (int i = 0; i < propertiesList.size(); i++) {
                String propertiesPathString = propertiesList.get(i);
                log.warn("the properties path String is : " + propertiesPathString);
                if (!propertiesFileClasspath.endsWith(File.separator)) {
                    propertiesFileClasspath = propertiesFileClasspath + File.separator + path + propertiesPathString;
                    log.warn("the final resources path is : " + propertiesFileClasspath);
                } else {
                    propertiesFileClasspath = propertiesFileClasspath + path + propertiesPathString;
                    log.warn("the final resources path is : " + propertiesFileClasspath);
                }
                Resource resource = new InputStreamResource(new FileInputStream(propertiesFileClasspath));
                resources[i] = resource;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        propertiesFactoryBean.setLocations(resources);
        return propertiesFactoryBean;
    }

}
