package com.learning.springMvc.service;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.web.servlet.ModelAndView;

import com.learning.springMvc.dto.Credential;
import com.learning.springMvc.dto.PasswordReset;

public interface LoginService {

	String login(Credential credential,HttpSession session);

	Map<String, Boolean> forgotPassword(@Valid PasswordReset passwordReset);

}
