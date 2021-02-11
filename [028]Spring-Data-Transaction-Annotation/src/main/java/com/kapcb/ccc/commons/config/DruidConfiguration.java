package com.kapcb.ccc.commons.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.mysql.cj.jdbc.Driver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Properties;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * <a>Title: DruidConfiguration </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/11 12:41
 */
@Configuration
@PropertySource(value = {"druid.properties"}, ignoreResourceNotFound = true)
public class DruidConfiguration {

    @Value("${druid.data.source.username}")
    private String dataSourceName;

    @Value("${druid.data.source.password}")
    private String dataSourcePassword;

    @Value("${druid.data.source.url}")
    private String dataSourceUrl;

    @Value("${druid.data.source.driven}")
    private String dataSourceDriven;

    @Value("${druid.data.source.dbType}")
    private String dataSourceDBType;

    @Value("${druid.data.source.initialSize}")
    private String dataSourceInitialSize;

    @Value("${druid.data.source.maxActive}")
    private String dataSourceMaxActive;

    @Value("${druid.data.source.maxWait}")
    private String dataSourceMaxWait;

    @Value("${druid.data.source.timeBetweenEvictionRunsMillis}")
    private String dataSourceTimeBetweenEvictionRunsMillis;

    @Value("${druid.data.source.minEvictableIdleTimeMillis}")
    private String dataSourceMinEvictableIdleTimeMillis;

    @Value("${druid.data.source.validationQuery}")
    private String dataSourceValidationQuery;

    @Value("${druid.data.source.testOnReturn}")
    private String dataSourceTestOnReturn;

    @Value("${druid.data.source.testOnBorrow}")
    private String dataSourceTestOnBorrow;

    @Value("${druid.data.source.testWhileIdle")
    private String dataSourceTestWhileIdle;

    @Value("${druid.data.source.poolPreparedStatements}")
    private String dataSourcePoolPreparedStatements;

    @Value("${druid.data.source.maxPoolPreparedStatementPerConnectionSize}")
    private String dataSourceMaxPoolPreparedStatementPerConnectionSize;

    @Value("${druid.data.source.useGlobalDataSourceStat}")
    private String dataSourceUseGlobalDataSourceStat;

    @Value("${druid.data.source.connectionProperties}")
    private String dataSourceConnectionProperties;

    @Bean(value = "dataSource")
    public DataSource druidDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(dataSourceName);
        druidDataSource.setPassword(dataSourcePassword);
        druidDataSource.setUrl(dataSourceUrl);
        druidDataSource.setDriverClassName(dataSourceDriven);
        druidDataSource.setDbType(dataSourceDBType);
        druidDataSource.setInitialSize(Integer.parseInt(dataSourceInitialSize));
        druidDataSource.setMaxActive(Integer.parseInt(dataSourceMaxActive));
        druidDataSource.setMaxWait(Long.parseLong(dataSourceMaxWait));
        druidDataSource.setTimeBetweenEvictionRunsMillis(Long.parseLong(dataSourceTimeBetweenEvictionRunsMillis));
        druidDataSource.setMinEvictableIdleTimeMillis(Long.parseLong(dataSourceMinEvictableIdleTimeMillis));
        druidDataSource.setValidationQuery(dataSourceValidationQuery);
        druidDataSource.setTestOnReturn(Boolean.parseBoolean(dataSourceTestOnReturn));
        druidDataSource.setTestOnBorrow(Boolean.parseBoolean(dataSourceTestOnBorrow));
        druidDataSource.setTestWhileIdle(Boolean.parseBoolean(dataSourceTestWhileIdle));
        druidDataSource.setPoolPreparedStatements(Boolean.parseBoolean(dataSourcePoolPreparedStatements));
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(Integer.parseInt(dataSourceMaxPoolPreparedStatementPerConnectionSize));
        druidDataSource.setUseGlobalDataSourceStat(Boolean.parseBoolean(dataSourceUseGlobalDataSourceStat));
        Properties properties = new Properties();
        String[] split = dataSourceConnectionProperties.split(", ");
        Arrays.stream(split).map(DruidConfiguration::getDruidConnectProperties);
        properties.setProperty()
        druidDataSource.setConnectProperties(new Properties().setProperty());
        return druidDataSource;
    }


    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        jdbcTemplate.setLazyInit(true);
        return jdbcTemplate;
    }

    public static <T> String getDruidConnectProperties(Function<T, String> function) {

    }
}
