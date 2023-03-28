package com.exam.exam.model;

import jakarta.persistence.Entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@ Table(name="users")

public class User implements UserDetails {
    
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name="userId",nullable=false)
	private Long id;
	private String username;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	private String profile;
	private String password;
	
	public User(String password) {
		super();
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<userRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<userRole> userRoles) {
		this.userRoles = userRoles;
	}

	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER,mappedBy ="user" )
	@JsonIgnore
	private Set<userRole> userRoles=new HashSet<>();
	
	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	private boolean enabled=true;

	public User() {
		
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public User(Long id, String username, String firstname, String lastname, String email, String phone, String profile,
			boolean enabled) {
		super();
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.profile = profile;
		this.enabled = enabled;
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		 Set<Authority> set= new HashSet();
		 this.userRoles.forEach(userRole->{
			set.add(new Authority(userRole.getRole().getRoleName())) ;
		 });
		return set;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	
} 