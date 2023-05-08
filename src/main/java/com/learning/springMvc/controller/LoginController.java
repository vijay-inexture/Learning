package com.learning.springMvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
	
	@PostMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/login?logout";
    }	
	
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
