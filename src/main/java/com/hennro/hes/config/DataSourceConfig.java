package com.hennro.hes.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.sys")
    public DataSourceProperties sysDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Qualifier("sysDataSource")
    @Primary
    @ConfigurationProperties("spring.datasource.sys")
    public DataSource sysDataSource() {
        return sysDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.cbs")
    public DataSourceProperties cbsDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Qualifier("cbsDataSource")
    @ConfigurationProperties("spring.datasource.cbs")
    public DataSource cbsDataSource() {
        return cbsDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.scm")
    public DataSourceProperties scmDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Qualifier("scmDataSource")
    @ConfigurationProperties("spring.datasource.scm")
    public DataSource scmDataSource() {
        return scmDataSourceProperties().initializeDataSourceBuilder().build();
    }
}
