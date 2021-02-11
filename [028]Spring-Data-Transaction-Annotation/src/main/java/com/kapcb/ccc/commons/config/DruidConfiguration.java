package com.kapcb.ccc.commons.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.sun.jndi.toolkit.ctx.StringHeadTail;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Properties;
import java.util.function.Function;
import java.util.function.Supplier;

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
@PropertySource(value = {"classpath:properties/druid.properties"}, ignoreResourceNotFound = true)
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
    private int dataSourceInitialSize;

    @Value("${druid.data.source.maxActive}")
    private int dataSourceMaxActive;

    @Value("${druid.data.source.maxWait}")
    private long dataSourceMaxWait;

    @Value("${druid.data.source.timeBetweenEvictionRunsMillis}")
    private long dataSourceTimeBetweenEvictionRunsMillis;

    @Value("${druid.data.source.minEvictableIdleTimeMillis}")
    private long dataSourceMinEvictableIdleTimeMillis;

    @Value("${druid.data.source.validationQuery}")
    private String dataSourceValidationQuery;

    @Value("${druid.data.source.testOnReturn}")
    private boolean dataSourceTestOnReturn;

    @Value("${druid.data.source.testOnBorrow}")
    private boolean dataSourceTestOnBorrow;

    @Value("${druid.data.source.testWhileIdle}")
    private boolean dataSourceTestWhileIdle;

    @Value("${druid.data.source.poolPreparedStatements}")
    private boolean dataSourcePoolPreparedStatements;

    @Value("${druid.data.source.maxPoolPreparedStatementPerConnectionSize}")
    private int dataSourceMaxPoolPreparedStatementPerConnectionSize;

    @Value("${druid.data.source.useGlobalDataSourceStat}")
    private boolean dataSourceUseGlobalDataSourceStat;

    @Value("${druid.data.source.connectionProperties}")
    private String dataSourceConnectionProperties;

    @Bean(value = "dataSource")
    public DruidDataSource druidDataSource() {
        System.out.println("dataSourceInitialSize = " + dataSourceInitialSize);
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUsername(dataSourceName);
        druidDataSource.setPassword(dataSourcePassword);
        druidDataSource.setUrl(dataSourceUrl);
        druidDataSource.setDriverClassName(dataSourceDriven);
        druidDataSource.setDbType(dataSourceDBType);
        druidDataSource.setInitialSize(dataSourceInitialSize);
        druidDataSource.setMaxActive(dataSourceMaxActive);
        druidDataSource.setMaxWait(dataSourceMaxWait);
        druidDataSource.setTimeBetweenEvictionRunsMillis(dataSourceTimeBetweenEvictionRunsMillis);
        druidDataSource.setMinEvictableIdleTimeMillis(dataSourceMinEvictableIdleTimeMillis);
        druidDataSource.setValidationQuery(dataSourceValidationQuery);
        druidDataSource.setTestOnReturn(dataSourceTestOnReturn);
        druidDataSource.setTestOnBorrow(dataSourceTestOnBorrow);
        druidDataSource.setTestWhileIdle(dataSourceTestWhileIdle);
        druidDataSource.setPoolPreparedStatements(dataSourcePoolPreparedStatements);
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(dataSourceMaxPoolPreparedStatementPerConnectionSize);
        druidDataSource.setUseGlobalDataSourceStat(dataSourceUseGlobalDataSourceStat);
        Properties properties = new Properties();
        String[] split = dataSourceConnectionProperties.split(";");
        String s3 = ArrayUtils.toString(split);
        System.out.println("s3 = " + s3);
        Arrays.stream(split).forEach(s -> {
            String[] split1 = s.split("=");
            String s1 = split1[0];
            System.out.println("s1 = " + s1);
            String s2 = split1[1];
            System.out.println("s2 = " + s2);
            properties.setProperty(split1[0], split1[1]);
        });

        getDruidConnectProperties(dataSourceConnectionProperties, S)
        druidDataSource.setConnectProperties(properties);
        return druidDataSource;
    }


    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        jdbcTemplate.setLazyInit(true);
        return jdbcTemplate;
    }

    private static <T> String getDruidConnectProperties(String propertiesString, Function<String, String> function) {
        return propertiesString == null ? "" : function.apply(propertiesString);
    }

}