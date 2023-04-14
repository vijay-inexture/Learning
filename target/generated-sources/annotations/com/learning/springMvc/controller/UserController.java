package com.learning.springMvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learning.springMvc.model.User;
import com.learning.springMvc.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/userform")
	public String userform() {
		return "userform";
	}
	
	@PostMapping("/user")
	public String createUser(@ModelAttribute User user) {
		userService.createUser(user);
		return "userStatus";
	}
	

}
