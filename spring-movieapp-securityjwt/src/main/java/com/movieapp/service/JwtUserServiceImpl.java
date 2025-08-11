package com.movieapp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.movieapp.model.JwtUser;
import com.movieapp.repository.IJwtUserRepository;


@Service
public class JwtUserServiceImpl implements UserDetailsManager{
	@Autowired
	private IJwtUserRepository userRepository;
	
	@Autowired
	private ModelMapper mapper;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		JwtUser jwtUser=userRepository.findByUsername(username);
		if(jwtUser==null)
			throw new UsernameNotFoundException("invalid username");
		//interface=new implementation class
		UserDetails userDetails=new User(username, jwtUser.getPassword(), jwtUser.getAuthorities());
		return userDetails;
		
	}

	@Override
	public void createUser(UserDetails userRequest) {
		//convert userRequest to jwtUser
		JwtUser jwtUser=mapper.map(userRequest,JwtUser.class);
		System.out.println("Service");
		System.out.println(jwtUser.getUsername());
		System.out.println(jwtUser.getPassword());
		userRepository.save(jwtUser);
		
	}

	@Override
	public void updateUser(UserDetails userRequest) {
		//convert userRequest to jwtUser
				JwtUser jwtUser=mapper.map(userRequest,JwtUser.class);
				userRepository.save(jwtUser);
		
	}

	@Override
	public void deleteUser(String username) {
		JwtUser user = userRepository.findByUsername(username);
		userRepository.delete(user);

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
