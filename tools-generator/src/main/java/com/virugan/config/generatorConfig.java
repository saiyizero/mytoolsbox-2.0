package com.virugan.config;

import com.virugan.api.getrDynamicJdbcOperate;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.omg.CORBA.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
public class generatorConfig {

    @Autowired
    private ConfigurableEnvironment environment;

    /*本模块动态数据源*/
    /****/
    @Bean(name = "getrDataSource")
    @Qualifier("getrDataSource")
    @ConfigurationProperties(prefix="getr.dynamic-data-source")
    public DataSource getrDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "getrSqlSessionFactory")
    @Qualifier("getrSqlSessionFactory")
    public SqlSessionFactory getrSqlSessionFactory(@Qualifier("getrDataSource") DataSource datasource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(datasource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactoryBean.setMapperLocations(resolver.getResources(environment.getProperty("mybatis.mapperLocations")));
        return sessionFactoryBean.getObject();
    }

    /*本模块动态数据操作*/
    @Bean
    public getrDynamicJdbcOperate getrDynamicJdbcOperate(@Qualifier("getrDataSource") DataSource datasource,
                                                         @Qualifier("getrSqlSessionFactory") SqlSessionFactory sessionFactory) {
        getrDynamicJdbcOperate dynamicJdbcOperate = new getrDynamicJdbcOperate();
        dynamicJdbcOperate.setDataSource(datasource);
        dynamicJdbcOperate.setSessionFactory(sessionFactory);
        return dynamicJdbcOperate;
    }


}
