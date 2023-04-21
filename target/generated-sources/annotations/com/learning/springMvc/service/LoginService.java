package com.learning.springMvc.service;

import javax.servlet.http.HttpSession;

import com.learning.springMvc.dto.Credential;

public interface LoginService {

	String loginForm(HttpSession session);

	String login(Credential credential,HttpSession session);

	String logout(HttpSession session);

}
