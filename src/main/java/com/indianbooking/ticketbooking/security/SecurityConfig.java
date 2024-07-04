package com.indianbooking.ticketbooking.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsManager userDetailsManager(@Qualifier("userDataSource")DataSource dataSource) {
		JdbcUserDetailsManager manager = new JdbcUserDetailsManager(dataSource);
		manager.setUsersByUsernameQuery("select user_name, password, active from userdetails where user_name=?");
		manager.setAuthoritiesByUsernameQuery("select user_name, role from roles where user_name=?");
		return manager;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				configurer -> configurer.requestMatchers("/").hasAnyRole("EMPLOYEE")
				.requestMatchers("/create_account","/save_details").permitAll()
				.requestMatchers("/swagger-ui/**").permitAll()
				.anyRequest().authenticated())
				.formLogin(form -> form.loginPage("/signin").loginProcessingUrl("/login").permitAll())
				.logout(logout -> logout.permitAll());

		return http.build();
	}

}