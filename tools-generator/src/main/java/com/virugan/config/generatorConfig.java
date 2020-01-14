package com.virugan.config;

import com.virugan.api.getrDynamicJdbcOperate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class generatorConfig {
    /*本模块动态数据源*/
    /****/
    @Bean(name = "getrDataSource")
    @Qualifier("getrDataSource")
    @ConfigurationProperties(prefix="getr.dynamic-data-source")
    public DataSource getrDataSource() {
        return DataSourceBuilder.create().build();
    }

    /*本模块动态数据操作*/
    @Bean
    public getrDynamicJdbcOperate getrDynamicJdbcOperate(@Qualifier("getrDataSource") DataSource datasource) {
        getrDynamicJdbcOperate dynamicJdbcOperate = new getrDynamicJdbcOperate();
        dynamicJdbcOperate.setDataSource(datasource);
        return dynamicJdbcOperate;
    }

}
