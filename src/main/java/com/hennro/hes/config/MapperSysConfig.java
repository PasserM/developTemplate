package com.hennro.hes.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.hennro.hes.module.sys.core.mapper"}, sqlSessionFactoryRef = "sqlSessionFactorySys")
public class MapperSysConfig {

    @Autowired
    @Qualifier("sysDataSource")
    private DataSource dataSourceSys;

    @Bean
    @Primary
    public SqlSessionFactory sqlSessionFactorySys() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSourceSys); // 使用titan数据源, 连接titan库
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/sys/*.xml"));
        return factoryBean.getObject();
    }

    @Bean
    @Primary
    public SqlSessionTemplate sqlSessionTemplateSys() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactorySys());
    }
}
