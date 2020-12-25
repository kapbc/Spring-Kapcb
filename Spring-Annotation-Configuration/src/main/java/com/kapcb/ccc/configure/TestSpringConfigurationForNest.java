package com.kapcb.ccc.configure;

import com.kapcb.ccc.domain.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <a>Title: TestSpringConfigurationForNest </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/26 - 0:39
 */
@Configuration
@ComponentScan(basePackages = "com.kapcb.ccc.domain")
public class TestSpringConfigurationForNest {

    public TestSpringConfigurationForNest() {
        System.out.println("TestSpringConfigurationForNest Begin to initial....");
    }

    @Configuration
    public static class DataSourceConfiguration{
        @Bean
        public DataSource dataSource(){
            return new DataSource();
        }
    }
}
