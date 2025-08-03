package com.productapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.productapp.service.ApiUserServiceImpl;

@Configuration
@EnableWebSecurity
public class WebConfig {

	//Authentication
	@Bean
	UserDetailsService userDetailsService() {
		return new ApiUserServiceImpl();
	}
	
	//password Encoder
	@Bean
	PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	//authentication provider
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider= new DaoAuthenticationProvider(userDetailsService());
		authProvider.setPasswordEncoder(encoder());		
		return authProvider;
	}
	//authorization
}
