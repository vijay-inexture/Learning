package com.learning.springMvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.learning.springMvc.dto.Credential;
import com.learning.springMvc.service.LoginService;


@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;

	@GetMapping("/login")
	public String loginForm(HttpSession session) {
		return loginService.loginForm(session);
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute Credential credential, HttpSession session) {
		return loginService.login(credential, session);
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		return loginService.logout(session);
	}
}
