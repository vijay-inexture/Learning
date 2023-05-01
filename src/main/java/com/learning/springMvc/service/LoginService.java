package com.learning.springMvc.service;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.learning.springMvc.dto.Credential;
import com.learning.springMvc.dto.PasswordReset;

public interface LoginService {

	String login(Credential credential,HttpSession session);

	void forgotPassword(@Valid PasswordReset passwordReset);

}
