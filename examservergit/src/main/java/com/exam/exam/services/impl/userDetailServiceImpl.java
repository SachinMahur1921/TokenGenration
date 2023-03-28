package com.exam.exam.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.exam.exam.model.User;
import com.exam.exam.repo.userRepository;
 @Component
public class userDetailServiceImpl implements UserDetailsService {
      @Autowired
	 private userRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
	User user =this.userRepository.findByUsername(username);
    
	if(user==null)
	{
		System.out.println("user not found");
		 throw new  UsernameNotFoundException("user not found");
	}
	return user;
		
	}
	
	

}
