package com.learning.springMvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.learning.springMvc.model.User;
import com.learning.springMvc.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/home")
	public String home() {
		return userService.home();
	}
	
	@GetMapping("/userform")
	public String userForm() {
		return userService.userForm();
	}
	
	@PostMapping("/user")
	public String createUser(@ModelAttribute User user) {
		return userService.createUser(user);
	}
	
	@GetMapping("/user")
	public ModelAndView getAllUser() {
		return userService.getAllUser();
	}
	
	@GetMapping("/user/{email}")
	public ModelAndView getUserByEmail(@PathVariable("email") String email) {
		return userService.getUserByEmail(email+".com");
	}
	
	@GetMapping("/user/id/{userId}")
	public ModelAndView getUserByEmail(@PathVariable("userId") Long userId) {
		return userService.getUserById(userId);
	}
	

}
