package com.learning.springMvc.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PasswordReset {
	
	@NotEmpty(message = "Please enter your Email")
	@Email(message = "Please enter valid Email")
	private String email;
	@NotEmpty(message = "Please enter your Password")
	private String password;
	@NotEmpty(message = "Please enter your new Password")
	private String newPassword;
	@NotEmpty(message = "Please enter Confirm Password")
	private String confirmPassword;
	
	public PasswordReset() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PasswordReset(@Email String email, @NotNull String password, @NotNull String newPassword,
			@NotNull String confirmPassword) {
		super();
		this.email = email;
		this.password = password;
		this.newPassword = newPassword;
		this.confirmPassword = confirmPassword;
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

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "PasswordReset [email=" + email + ", password=" + password + ", newPassword=" + newPassword
				+ ", confirmPassword=" + confirmPassword + "]";
	}
	
	

}
