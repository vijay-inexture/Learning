package com.learning.springMvc.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;


public class PasswordReset {
	
	@Email
	private String email;
	@NotNull
	private String password;
	@NotNull
	private String newPassword;
	@NotNull
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
