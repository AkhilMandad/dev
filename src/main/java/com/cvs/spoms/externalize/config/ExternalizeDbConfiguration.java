package com.cvs.spoms.externalize.config;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@PropertySource("file:${spoms.jdbc.property.file.location}")
@EnableJpaRepositories(basePackages = "com.cvs.spoms.externalize.repo", entityManagerFactoryRef = "securityEntityManager", transactionManagerRef = "securityTransactionManager")
public class ExternalizeDbConfiguration {
    @Autowired
    private Environment env;

    public ExternalizeDbConfiguration() {
        super();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean securityEntityManager() {
        System.out.println("loading security");
        final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(securityDataSource());
        em.setPackagesToScan("com.cvs.spoms.externalize.entity");

        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        final HashMap<String, Object> properties = new HashMap<String, Object>();
        properties.put("hibernate.generate_statistics", env.getProperty("hibernate.generate_statistics"));
        properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        System.out.println("Show SQL "+env.getProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        properties.put("hibernate.jdbc.batch_size", env.getProperty("hibernate.jdbc.batch_size"));
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean(name = "securityDataSource")
    public DataSource securityDataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(Preconditions.checkNotNull(env.getProperty("jdbc.driverClassName")));
        dataSource.setUrl(Preconditions.checkNotNull(env.getProperty("security.jdbc.url")));
        dataSource.setUsername(Preconditions.checkNotNull(env.getProperty("security.jdbc.user")));
        dataSource.setPassword(Preconditions.checkNotNull(env.getProperty("security.jdbc.pass")));

        return dataSource;
    }

    @Bean
    public PlatformTransactionManager securityTransactionManager() {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(securityEntityManager().getObject());
        return transactionManager;
    }

    @Bean(name = "securityJdbcTemplate")
    public JdbcTemplate securityJdbcTemplate(@Qualifier("securityDataSource") DataSource ds) {
        return new JdbcTemplate(ds);
    }
}
