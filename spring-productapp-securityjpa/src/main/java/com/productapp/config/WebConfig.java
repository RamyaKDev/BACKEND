 package com.productapp.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import static org.springframework.security.config.Customizer.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.productapp.service.ApiUserServiceImpl;

@Configuration
@EnableWebSecurity
public class WebConfig {
	@Bean
	ModelMapper mapper() {
		return new ModelMapper();
	}

	// authentication bean
	@Bean
	UserDetailsService userDetailsService() {
		return new ApiUserServiceImpl();
	}
	
	// password encoder
	 @Bean
	 PasswordEncoder encoder(){
		 return new BCryptPasswordEncoder();
	 }
	// authentication provider bean
	 @Bean
	 DaoAuthenticationProvider authenticationProvider() {
		 DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService());
		 provider.setPasswordEncoder(encoder());
		 return provider;
	 }
	//authorization bean
	 @Bean
	 SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
			 .csrf(csrf->csrf.disable())
		 	 .authorizeHttpRequests(httpRequest-> httpRequest
		 		.requestMatchers("/user-api/v1/apiusers/register","/product-api/v1/welcome").permitAll()
		 		// authorize users with role as admin and user
		 		.requestMatchers("/product-api/v1/products/**").hasAnyRole("ADMIN","USER")
		 		// authorize users with role as admin and user
		 		.requestMatchers("/product-api/v1/admin/**").hasRole("ADMIN")
		 		.anyRequest().authenticated())
		 	    .httpBasic(withDefaults())
		 	    .build();
		 	
	 }

}
