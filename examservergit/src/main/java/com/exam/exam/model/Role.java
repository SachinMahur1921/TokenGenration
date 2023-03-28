package com.exam.exam.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="roles")
public class Role {
     @Id
     
	private Long roleId;
	private String roleName;
	  
	@ OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy ="role" )
	private Set<userRole> userRoles=new HashSet<>();
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(Long roleId, String roleName, Set<userRole> userRoles) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.userRoles = userRoles;
	}
	public Set<userRole> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(Set<userRole> userRoles) {
		this.userRoles = userRoles;
	}
	public Role(Long roleId, String roleName) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
