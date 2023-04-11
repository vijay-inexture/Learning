package com.vijay.springMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vijay.springMvc.model.UserData;

@Controller
public class UserController {
	
	@ModelAttribute
	//use when we need some common feature to set
	//@ModelAttribute on method 
	public void common(Model model) {
		model.addAttribute("title", "Hey There");
	}
	
	@RequestMapping("/userform")
	public String addUser() {
		return "userform";
	}

	@RequestMapping("/user")
	// modelAttribute get form all data into userData model and set data and also set into model 
	//@ModelAttribute as method handler
	public String getUser(@ModelAttribute UserData userData, Model model) {
		return "user";
	}
	
//	@RequestMapping("/user")
//	public String getUserDetail(@ModelAttribute UserData userData, ModelAndView model) {
//		return "user";
//	}
	
	
}
