package com.productapp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.productapp.model.ApiUser;
import com.productapp.model.ApiUserDto;
import com.productapp.repository.ApiUserRepository;
@Service
public class ApiUserServiceImpl implements UserDetailsManager{
	@Autowired
	private ApiUserRepository apiUserRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ApiUser apiUser=	apiUserRepository.findByUsername(username);
		if(apiUser==null)
			throw new UsernameNotFoundException("invalid user");
		return apiUser;
	}

	@Override
	public void createUser(UserDetails apiUserDto) {
		ApiUser user=mapper.map(apiUserDto, ApiUser.class);
		apiUserRepository.save(user);
		
	}

	@Override
	public void updateUser(UserDetails apiUserDto) {
		ApiUser apiUser=mapper.map(apiUserDto, ApiUser.class);
		apiUserRepository.save(apiUser);
		
	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		
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
