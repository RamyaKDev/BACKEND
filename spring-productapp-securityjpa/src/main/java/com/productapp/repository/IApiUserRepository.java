package com.productapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.productapp.model.ApiUser;
@Repository
public interface IApiUserRepository extends JpaRepository<ApiUser, Integer>{
	
	@Query("from ApiUser au inner join au.roles r where au.username=?1")
	ApiUser findByUsername(String username);

	
}
