package com.hennro.hes.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.hennro.hes.module.scm.mapper"}, sqlSessionFactoryRef = "sqlSessionFactoryScm")
public class MapperScmConfig {

    @Autowired
    @Qualifier("scmDataSource")
    private DataSource dataSourceScm;

    @Bean
    public SqlSessionFactory sqlSessionFactoryScm() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSourceScm); // 使用titan数据源, 连接titan库

        //添加XML目录
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/scm/*.xml"));
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplateScm() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryScm());
    }
}
