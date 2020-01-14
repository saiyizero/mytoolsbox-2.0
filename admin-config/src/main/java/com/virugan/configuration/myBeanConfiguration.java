package com.virugan.configuration;

import com.virugan.api.localJdbcOperate;
import com.virugan.myImp.defaultComponentHandle;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * 注入全局处理Bean
 * **/
@Configuration
public class myBeanConfiguration {

    /*表实体默认处理*/
    @Bean
    public defaultComponentHandle defaultComponentHandle () {
        return new defaultComponentHandle();
    }

    /*本地数据源*/
    @Bean(name = "localDataSource")
    @Qualifier("localDataSource")
    @Primary
    @ConfigurationProperties(prefix="spring.datasource.local")
    public DataSource localDataSource() {
        return DataSourceBuilder.create().build();
    }

    /*本地数据库操作*/
    @Bean
    public localJdbcOperate localJdbcOperate (@Qualifier("localDataSource") DataSource datasource) {
        localJdbcOperate localjdbcoperate = new localJdbcOperate();
        localjdbcoperate.setDataSource(datasource);
        return localjdbcoperate;
    }
}
