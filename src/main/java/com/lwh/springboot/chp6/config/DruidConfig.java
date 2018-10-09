package com.lwh.springboot.chp6.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author lwh
 * @date 2018-10-09
 * @desp 以配置类的方式配置Druid数据源
 */

@Configuration
public class DruidConfig {

    /**
     * prefix：指定application.yml中的配置信息
     * @return
     */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }
}
