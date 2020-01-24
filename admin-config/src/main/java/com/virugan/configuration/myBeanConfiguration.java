package com.virugan.configuration;

import com.virugan.api.localJdbcOperate;
import com.virugan.myImp.defaultComponentHandle;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * 注入全局处理Bean
 * **/
@Configuration
public class myBeanConfiguration {

    @Autowired
    private ConfigurableEnvironment environment;

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

    @Bean(name = "localSqlSessionFactory")
    @Qualifier("localSqlSessionFactory")
    @Primary
    public SqlSessionFactory getrSqlSessionFactory(@Qualifier("localDataSource") DataSource datasource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(datasource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactoryBean.setMapperLocations(resolver.getResources(environment.getProperty("mybatis.mapperLocations")));
        return sessionFactoryBean.getObject();
    }

    /*本地数据库操作*/
    @Bean
    public localJdbcOperate localJdbcOperate (@Qualifier("localDataSource") DataSource datasource,
                                              @Qualifier("localSqlSessionFactory") SqlSessionFactory sessionFactory) {
        localJdbcOperate localjdbcoperate = new localJdbcOperate();
        localjdbcoperate.setDataSource(datasource);
        localjdbcoperate.setSessionFactory(sessionFactory);

        return localjdbcoperate;
    }

}
