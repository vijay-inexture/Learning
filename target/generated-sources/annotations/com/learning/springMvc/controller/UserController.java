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
		return "home";
	}
	
	@GetMapping("/userform")
	public String userForm() {
		return "userForm";
	}
	
	@PostMapping("/user")
	public String createUser(@ModelAttribute User user) {
		User userByEmail = userService.getUserByEmail(user.getEmail());
		System.out.println(userByEmail);
		if(userByEmail!=null) {
			throw new RuntimeException("User already exist with email!");
		}
		userService.createUser(user);
		return "userStatus";
	}
	
	@GetMapping("/user")
	public ModelAndView getAllUser() {
		List<User> users = userService.getAllUser();
		System.out.println(users);
		ModelAndView mv = new ModelAndView();
		users.forEach(user -> System.out.println(user.getName()));
		mv.addObject("users", users);
		mv.setViewName("users");
		return mv;
	}
	
	@GetMapping("/user/{email}")
	public ModelAndView getUserByEmail(@PathVariable("email") String email) {
		System.out.println(email);
		User user = userService.getUserByEmail(email+".com");
		if(user==null) {
			throw new RuntimeException("User not found!");
		}
		System.out.println(user);
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);
		mv.setViewName("user");
		return mv;
	}
	

}
