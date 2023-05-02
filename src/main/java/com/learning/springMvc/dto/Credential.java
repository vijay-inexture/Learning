package com.learning.springMvc.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class Credential {
	
	@NotEmpty(message = "Please enter your Email")
	@Email(message = "Please enter valid Email")
	private String email;
	@NotEmpty(message = "Please enter your password")
//    @Size(min = 6, message = "Minimum 6 characters required")
	private String password;
	
	public Credential() {
		super();
	}

	public Credential(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
