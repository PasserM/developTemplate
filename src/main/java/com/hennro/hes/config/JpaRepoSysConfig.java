package com.hennro.hes.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * Created by anxpp.com on 2018/6/23.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "sysEntityManagerFactory", transactionManagerRef = "sysTransactionManager", basePackages = "com.hennro.hes.module.sys.core.repo")
public class JpaRepoSysConfig {

    @Autowired
    @Qualifier("sysDataSource")
    private DataSource dataSourceSys;

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean sysEntityManagerFactory() {

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);

        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.hennro.hes.module.sys.core.entity");
        factory.setPersistenceUnitName("sysPersistenceUnit");
        factory.setDataSource(dataSourceSys);
        return factory;
    }

    @Bean
    @Primary
    public PlatformTransactionManager sysTransactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory);
        return txManager;
    }
}