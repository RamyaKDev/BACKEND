package com.productapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.productapp.model.JwtUser;
@Repository
public interface IJwtUserRepository extends JpaRepository<JwtUser, Integer>{
	
	@Query("from JwtUser ju inner join ju.roles r where ju.username=?1")
	JwtUser findByUsername(String username);

	
}
