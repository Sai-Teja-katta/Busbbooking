package com.indianbooking.ticketbooking.configuration;


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
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		basePackages = "com.indianbooking.ticketbooking.Entity.UserEntity",
		entityManagerFactoryRef = "userEntityManagerFactory",
		transactionManagerRef = "userEntityTransactionManager"
		
		)
public class Databaseconfig {
	@Bean
	@ConfigurationProperties("spring.datasource")
	public DataSourceProperties userDataSourceProp() {
		return new DataSourceProperties();
	}
	
	@Bean("userDataSource")
	@ConfigurationProperties("spring.datasource.configuration")
	public DataSource userDataSource() {
		return userDataSourceProp().initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}
	@Bean("userEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean userEntityFactory(EntityManagerFactoryBuilder builder) {
		return builder.dataSource(userDataSource()).packages("com.indianbooking.ticketbooking.Entity.UserEntity").build();
	}
	@Bean("userEntityTransactionManager")
	public PlatformTransactionManager userTransactionManager(final @Qualifier("userEntityManagerFactory")LocalContainerEntityManagerFactoryBean userEntityManagerFactory) {
		return new JpaTransactionManager(userEntityManagerFactory.getObject());
	}
}