package com.learning.springMvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.learning.springMvc.dto.PasswordReset;
import com.learning.springMvc.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";
	}
	
	
//	@GetMapping("/logout")
//	public String logout(HttpSession session) {
//		User sessionUser = (User) session.getAttribute("user");
//		if(sessionUser!=null) {
//			session.invalidate();
//		}
//		return "redirect:/login";
//	}
	
	@GetMapping("/forgotPassword")
	public String forgotPasswordForm() {
		return "forgotPasswordForm";
	} 
	
	@PostMapping("/forgotPassword")
	public ModelAndView forgotPassword(@Valid @ModelAttribute("passwordReset") PasswordReset passwordRest, BindingResult result) {
		ModelAndView model = new ModelAndView();
		//bean validation
		if(result.hasErrors()) {
			model.setViewName("forgotPasswordForm");
			return model;
		}
		//user email and password validation with db
		String errorMessage = loginService.forgotPassword(passwordRest);
		if(!errorMessage.isEmpty()) {
			model.addObject("errorMessage", errorMessage);
			model.setViewName("forgotPasswordForm");
			return model;
		}
		model.setViewName("redirect:/login");
		return model;
	}
}
