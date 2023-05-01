package com.learning.springMvc.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.learning.springMvc.dto.Credential;
import com.learning.springMvc.dto.PasswordReset;
import com.learning.springMvc.model.User;
import com.learning.springMvc.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/login")
	public String loginForm(HttpSession session) {
		User sessionUser = (User) session.getAttribute("user");
		if(sessionUser!=null) {
			return "redirect:/users/"+sessionUser.getId();
		}
		return "loginForm";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute Credential credential, HttpSession session) {
		return loginService.login(credential, session);
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		User sessionUser = (User) session.getAttribute("user");
		if(sessionUser!=null) {
			session.invalidate();
		}
		return "redirect:/login";
	}
	
	@GetMapping("/forgotPasswordForm")
	public String forgotPasswordForm() {
		return "forgotPasswordForm";
	} 
	
	@PostMapping("/forgotPassword")
	public ModelAndView forgotPassword(@Valid @ModelAttribute PasswordReset passwordRest) {
		loginService.forgotPassword(passwordRest);
		ModelAndView model = new ModelAndView();
		model.setViewName("redirect:/login");
		return model;
	}
}
