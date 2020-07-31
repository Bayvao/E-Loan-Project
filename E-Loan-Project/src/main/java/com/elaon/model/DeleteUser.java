package com.elaon.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class DeleteUser {

	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
