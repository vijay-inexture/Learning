package com.learning.springMvc.service.impl;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.learning.springMvc.dao.UserDao;
import com.learning.springMvc.dto.PasswordReset;
import com.learning.springMvc.model.User;
import com.learning.springMvc.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public String forgotPassword(@Valid PasswordReset passwordReset) {
		String errorMessage = "";
		User user = userDao.findByEmail(passwordReset.getEmail());
		if(user==null) {
			errorMessage = "User not exist with Email";
			return errorMessage;
		}
		boolean validPassword = passwordEncoder.matches(passwordReset.getPassword(), user.getPassword());
		if(!validPassword) {
			errorMessage = "Invalid Password";
			return errorMessage;
		}
		if(!passwordReset.getNewPassword().equals(passwordReset.getConfirmPassword())) {
			errorMessage = "New Password and ConfirmPassword Must be same";
			return errorMessage;
		}
		userDao.updatePassword(passwordReset.getEmail(), passwordReset.getNewPassword());
		return errorMessage;
	}

	
}
