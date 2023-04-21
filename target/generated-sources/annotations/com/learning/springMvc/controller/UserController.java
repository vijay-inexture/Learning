package com.learning.springMvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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

import jakarta.validation.Valid;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/userform")
	public String userForm() {
		return userService.userForm();
	}
	
	@PostMapping("/users")
	public ModelAndView createUser(@Valid @ModelAttribute  User user) {
		System.out.println("User controller");
		return userService.createUser(user);
	}
	
	@GetMapping("/users")
	public ModelAndView getAllUser(HttpSession session) {
		return userService.getAllUser(session);
	}
	
	@GetMapping("/users/{userId}")
	public ModelAndView getUserByEmail(@PathVariable("userId") Long userId,HttpSession session) {
		return userService.getUserById(userId, session);
	}
	
	@GetMapping("/users/{userId}/updateUser")
	public ModelAndView  updateUser(@PathVariable("userId") Long userId,HttpSession session) {
		return userService.updateUser(userId, session);
	}
	
}
