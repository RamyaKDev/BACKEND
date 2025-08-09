package com.movieapp.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@EnableWebSecurity
@Configuration
public class WebConfig {
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	
	@Autowired
	private JwtAuthenticationEntryPoint authenticationEntryPoint;
	
//	// authentication bean
//	@Bean
//	UserDetailsService userDetailsService() {
//		return new  JwtUserServiceImpl();
//	}
	
	// password encoder
	 @Bean
	 PasswordEncoder encoder(){
		 return new BCryptPasswordEncoder();
	 }
	// authentication manager bean
	 @Bean
		AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
			return config.getAuthenticationManager();
		}
	 
	//authorization bean
	 @Bean
	 SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
			 .csrf(csrf->csrf.disable())
		 	 .authorizeHttpRequests(httpRequest-> httpRequest
		 		.requestMatchers("/user-api/v1/register","/user-api/v1/authenticate").permitAll()
		 		// authorize users with role as admin and user
		 		.requestMatchers("/movies-api/v1/movies/**").hasAnyAuthority("ADMIN","USER")
		 		// authorize users with role as admin and user
		 		.requestMatchers("/movies-api/v1/admin/**").hasAuthority("ADMIN")
		 		.anyRequest().authenticated())
		 	   // use Jwtauthenticationentry point to send errors
				 .exceptionHandling(configurer->configurer.authenticationEntryPoint(authenticationEntryPoint))
					
				 // session is stateless here - do not handle session- here each request is new 
				.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				
				// move to the filter in the flow
				// the requestfilter will be called before usernamepasswordfilter
				.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
				.build();
		 	 
		 	 
		 	 
		 	 
		 
	
	 }
	 
	 
}
