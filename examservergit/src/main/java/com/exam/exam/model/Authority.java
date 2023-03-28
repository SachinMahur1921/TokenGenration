package com.exam.exam.model;

import org.springframework.security.core.GrantedAuthority;

public class Authority implements GrantedAuthority{
   
	public String Authority;
	
	
	public Authority() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Authority(String authority) {
		super();
		Authority = authority;
	}

	public void setAuthority(String authority) {
		Authority = authority;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
