package com.movieapp.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;

//import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="user")
public class JwtUser implements UserDetails {
	@Column(unique=true)
	private String username;
	private String password;
	@Id
	@GeneratedValue
	private Integer userId;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name = "user_roles",joinColumns =@JoinColumn(name="user_id") )
	private List<String> roles;//[admin,storemanager,salesman]
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
