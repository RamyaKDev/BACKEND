package com.productapp.model;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class ApiUserDto implements UserDetails{
	
	private String username;
	private String password;
	private Integer userId;
	private String email;
	private Set<String> roles;
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	//using streams
			//convert roles to stream
			List<SimpleGrantedAuthority> authorities = roles.stream()
			      //convert each role to GA object
			      .map(role-> new SimpleGrantedAuthority(role))
			      .toList();
			
			return authorities;
	}
}
