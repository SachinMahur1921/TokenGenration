package com.exam.exam.Controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.exam.model.Role;
import com.exam.exam.model.User;
import com.exam.exam.model.userRole;

import com.exam.exam.services.impl.userServiceImpl;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
//	  @Autowired
//	 private UserService  userservice;
//	 
	  @Autowired
	  private userServiceImpl userServiceImpl;
	  
     @PostMapping("/")
	public User createUser(@RequestBody User user) throws Exception {
    	 Set<userRole> roles=new HashSet<>();
    	  Role role=new Role();
    	   role.setRoleId(45L);
    	   role.setRoleName("Normal");
    	   userRole userRole=new userRole();
    	   userRole.setUser(user);
    	   userRole.setRole(role);
    	  roles.add(userRole);
		return this.userServiceImpl.createUser(user, roles);
//		return null;
		
		
	}
     @GetMapping("/{username}")
		
		public User getUser(@PathVariable ("username") String username)
		{
			return this.userServiceImpl.getUser(username);
			
		}
            @DeleteMapping("/{userId}")
         public void deleteUser(@PathVariable("userId")Long userId)
         {
        	// this.userservice.deleteUser(userId);
            	this.userServiceImpl.deleteUser(userId);
         }
            
            @PutMapping("/{userId}")
              public  void updateUser(@RequestBody User user)
            {
            	
            	Set<userRole> roles=new HashSet<>();
          	  Role role=new Role();
          	   role.setRoleId(45L);
          	   role.setRoleName("Normal");
          	   userRole userRole=new userRole();
          	   userRole.setUser(user);
          	   userRole.setRole(role);
          	  roles.add(userRole);
          	this.userServiceImpl.updateUser(user, roles);
            }
            
            
}
