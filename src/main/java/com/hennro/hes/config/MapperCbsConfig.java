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
@MapperScan(basePackages = {"com.hennro.hes.module.cbs.core.mapper"}, sqlSessionFactoryRef = "sqlSessionFactoryCbs")
public class MapperCbsConfig {

    @Autowired
    @Qualifier("cbsDataSource")
    private DataSource dataSourceCbs;

    @Bean
    public SqlSessionFactory sqlSessionFactoryCbs() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSourceCbs); // 使用titan数据源, 连接titan库

//        factoryBean.setTypeAliasesPackage("com.cqwv.wx.model");

//        //分页插件
//        PageHelper pageHelper = new PageHelper();
//        Properties properties = new Properties();
//        properties.setProperty("reasonable", "false");
//        properties.setProperty("supportMethodsArguments", "true");
//        properties.setProperty("returnPageInfo", "check");
//        properties.setProperty("params", "count=countSql");
//        pageHelper.setProperties(properties);
//
//        // 添加插件
//        factoryBean.setPlugins(new Interceptor[]{pageHelper});

        //添加XML目录
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/cbs/*.xml"));
        return factoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplateCbs() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryCbs());
    }
}
