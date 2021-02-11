package com.kapcb.ccc.commons.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * <a>Title: ContextConfiguration </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 * <p>
 * 声明配置类 {@link Configuration}
 * 开启事务注解支持 {@link EnableTransactionManagement}
 * 开启包扫描 {@link ComponentScan}
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/11 12:41
 */
@Configuration
@EnableTransactionManagement
@Import(DruidDataSource.class)
@ComponentScan(basePackages = {"com.kapcb.ccc"}, includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class)})
public class ContextConfiguration {

    @Bean
    public TransactionManager dataSourceTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
}