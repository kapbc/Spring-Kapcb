package com.kapcb.ccc.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * <a>Title: TestSpringConfigurationForXml </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/25 - 23:16
 */
@Configuration
@ImportResource("classpath:applicationContext.xml")
@Import(TestSpringConfiguration.class)
public class TestSpringConfigurationForXml {

    public TestSpringConfigurationForXml() {
        System.out.println("TestSpringConfigurationForXml is start up ...");
    }
}
