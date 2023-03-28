package com.exam.exam.services.impl;

import java.util.Optional;
import java.util.Set;
import java.lang.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.exam.model.User;
import com.exam.exam.model.userRole;
import com.exam.exam.repo.roleRepository;
import com.exam.exam.repo.userRepository;


 @Service
public class userServiceImpl{
   @Autowired
	private userRepository userRepository;
   
    @Autowired
   private roleRepository roleRepository;
    
	
	public User createUser(User user, Set<userRole> userRoles) throws Exception  {
		// TODO Auto-generated method stub
		User local=this.userRepository.findByUsername(user.getUsername());
		 if(local!=null)
		 {
			 System.out.println("User is already there");
		    throw new Exception("user present already");
		 }
		 else {
			 //user create
			 for(userRole ur:userRoles)
			 {
				 roleRepository.save(ur.getRole());
			 }
			 
			 user.getUserRoles().addAll(userRoles);
			local= this.userRepository.save(user);
			 
		 }
		return null;
	}
	//getting user by username
	
	public User getUser(String username) {
		// TODO Auto-generated method stub
		return this.userRepository.findByUsername(username);
	}
	
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
//		Optional<User> findById = this.userRepository.findById(userId);
//		User user1= findById.get();
//		user1.setEmail("rajat@gmail.com");
//		this.userRepository.saveAndFlush(user1);
		this.userRepository.deleteById(userId);
	}

	public void updateUser(User user, Set<userRole> userRoles) {
		// TODO Auto-generated method stub
		 
		 for(userRole ur:userRoles)
		 {
			 roleRepository.save(ur.getRole());
		 }
		 
		 user.getUserRoles().addAll(userRoles);
		 this.userRepository.save(user);
		
	}
 
}
