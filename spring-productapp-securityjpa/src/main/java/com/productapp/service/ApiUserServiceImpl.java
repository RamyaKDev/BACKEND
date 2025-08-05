package com.productapp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.productapp.model.ApiUser;
import com.productapp.model.ApiUserRequest;

import com.productapp.repository.IApiUserRepository;
@Service
public class ApiUserServiceImpl implements UserDetailsManager{
	@Autowired
	private IApiUserRepository apiUserRepository;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ApiUser apiUser=apiUserRepository.findByUsername(username);
		if(apiUser==null)
			throw new UsernameNotFoundException("invalid username");
		//interface ref=implemetation class
		UserDetails userDetails=apiUser;
		return userDetails;
	}

	@Override
	public void createUser(UserDetails user) {
		ApiUser apiuser=(ApiUser) user;
		apiUserRepository.save(apiuser);
		
	}

	@Override
	public void updateUser(UserDetails user) {
		apiUserRepository.save((ApiUser)user);
		
	}

	@Override
	public void deleteUser(String username) {
		ApiUser user=apiUserRepository.findByUsername(username);
		apiUserRepository.delete(user);
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean userExists(String username) {
		// TODO Auto-generated method stub
		return false;
	}

}
