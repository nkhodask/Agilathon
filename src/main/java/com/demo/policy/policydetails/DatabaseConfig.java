package com.demo.policy.policydetails;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


/**
 * The Class DataBaseConfig.
 */
@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory", transactionManagerRef = "transactionManager")
@EnableTransactionManagement
public class DatabaseConfig {

    /**
     * The failure msg.
     */
    private static final String POLICY = "policy";
    /**
     * The logger.
     */
    private static final Logger LOGGER = LogManager.getLogger(DatabaseConfig.class);


    /** The property name database url. */
    @Value("${spring.datasource.url}")
    private String PROPERTY_NAME_DATABASE_URL;

    /** The property name database username. */
    @Value("${spring.datasource.username}")
    private String PROPERTY_NAME_DATABASE_USERNAME;

    /** The property name database password. */
    @Value("${spring.datasource.password}")
    private String PROPERTY_NAME_DATABASE_PASSWORD;

    /** The property name hibernate hbm2ddl. */
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String PROPERTY_NAME_HIBERNATE_HBM2DDL;

    /**
     * Transaction manager.
     *
     * @return the platform transaction manager
     */
    @Bean
    PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }

    /**
     * Entity manager factory.
     *
     * @return the local container entity manager factory bean
     */
    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory() {

            HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
            jpaVendorAdapter.setGenerateDdl(false);
            jpaVendorAdapter.setShowSql(true);

            LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();

            factoryBean.setDataSource(dataSource());
            factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
            factoryBean.setPackagesToScan(DatabaseConfig.class.getPackage().getName());
            return factoryBean;

    }
    /**
     * Data source.
     *
     * @return the data source
     */
    @Bean
    DataSource dataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).setName(POLICY).build();

    }

}