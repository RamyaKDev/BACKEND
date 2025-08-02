package com.productapp.model;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

//import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class ApiUser implements UserDetails {
	
	private String username;
	private String password;
	private Integer userId;
	private String email;
	private Set<String> roles;//[admin,storemanager,salesman]
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
//		List<GrantedAuthority> authorities =  new ArrayList<>();
//		//iterate thru the roles
//		for (String role : roles) {
//			//create a Simple GrantedAutority object
//			GrantedAuthority authority =  new SimpleGrantedAuthority(role);
//			authorities.add(authority);
//		}
//		return authorities;
		
		//using streams
		//convert roles to stream
		List<SimpleGrantedAuthority> authorities = roles.stream()
		      //convert each role to GA object
		      .map(role-> new SimpleGrantedAuthority(role))
		      .toList();
		
		return authorities;
		
		}

}
