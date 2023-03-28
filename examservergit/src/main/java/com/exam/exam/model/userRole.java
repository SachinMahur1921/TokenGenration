package com.exam.exam.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity

public class userRole {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long userRoleId;
  
   public Long getUserRoleId() {
	return userRoleId;
}
public userRole() {
	super();
	// TODO Auto-generated constructor stub
}
public void setUserRoleId(Long userRoleId) {
	this.userRoleId = userRoleId;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Role getRole() {
	return role;
}
public void setRole(Role role) {
	this.role = role;
}
@ManyToOne(fetch = FetchType.EAGER)
  private User user;
   @ManyToOne(fetch = FetchType.EAGER)
   private Role role;
}
