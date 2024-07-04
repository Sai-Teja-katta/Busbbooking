package com.indianbooking.ticketbooking.configuration;


import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		basePackages = "com.indianbooking.ticketbooking.Entity.BusEntity",
		entityManagerFactoryRef = "busEntityManagerFactory",
		transactionManagerRef = "busEntityTransactionManager"
		
		)
public class BusDataSourceConfig {
	@Bean
	@ConfigurationProperties("spring.seconddatasource")
	public DataSourceProperties busDataSourceProp() {
		return new DataSourceProperties();
	}
	
	@Bean
	@ConfigurationProperties("spring.seconddatasource.configuration")
	public DataSource busDataSource() {
		return busDataSourceProp().initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}
	@Bean("busEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean busEntityFactory(EntityManagerFactoryBuilder builder) {
		return builder.dataSource(busDataSource()).packages("com.indianbooking.ticketbooking.Entity.BusEntity").build();
	}
	@Bean
	public EntityManagerFactoryBuilder  entityManagerFactory() {
		HibernateJpaVendorAdapter vendor=new HibernateJpaVendorAdapter();
		vendor.setGenerateDdl(false);
		return new EntityManagerFactoryBuilder(vendor, new HashMap<>(), null);
	}
	@Bean("busEntityTransactionManager")
	public PlatformTransactionManager busTransactionManager(final @Qualifier("busEntityManagerFactory")LocalContainerEntityManagerFactoryBean busEntityManagerFactory) {
		return new JpaTransactionManager(busEntityManagerFactory.getObject());
	}
}