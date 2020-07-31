package com.elaon.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EloanUser {

	@NotNull(message="is required")
	@Size(min=1, message="is required")	
	private String userName;
	
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String password;
	
	private String formRole;
	
	public EloanUser() {
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFormRole() {
		return formRole;
	}

	public void setFormRole(String formRole) {
		this.formRole = formRole;
	}	
	
}