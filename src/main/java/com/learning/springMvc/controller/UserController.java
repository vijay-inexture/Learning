package com.learning.springMvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.learning.springMvc.dto.UserUpdateRequest;
import com.learning.springMvc.model.Address;
import com.learning.springMvc.model.User;
import com.learning.springMvc.service.UserService;


@Controller
@EnableMethodSecurity
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/createNew")
	public String createUserForm() {
		return "userForm";
	}
	
	@PostMapping("/users")
	public ModelAndView createUser(@Valid @ModelAttribute("user")  User user, BindingResult result) {
		ModelAndView model = new ModelAndView();
		if (result.hasErrors()) {
			model.setViewName("userForm");
			return model;
		}
	
		User userEntity = userService.createUser(user);
		
		model.setViewName("userStatus");
		model.addObject("userId", userEntity.getId());
		return model;
	}

	@GetMapping("/users")
	public ModelAndView getAllUser() {
		ModelAndView model = new ModelAndView();
		
		List<User> users = userService.getAllUser();
		
		model.addObject("users", users);
		model.setViewName("users");
		return model;
	}
	
	@GetMapping("/users/{userId}")
	@PreAuthorize("@userSecurity.userAccess(authentication, #userId)")
	public ModelAndView getUserById(@PathVariable("userId") Long userId) {
		ModelAndView model = new ModelAndView();
		
		User user = userService.getUserById(userId);
		
		model.addObject("user", user);
		model.setViewName("user");
		return model;
	}
	
	@GetMapping("/users/{userId}/updateUser")
	@PreAuthorize("@userSecurity.adminAccess(authentication, #userId)")
	public ModelAndView  updateUserForm(@PathVariable("userId") Long userId) {
		ModelAndView model = new ModelAndView();
		
		User user = userService.updateUserForm(userId);
		
		model.setViewName("userForm");
		model.addObject("user", user);
		model.addObject("addresses",user.getAddresses());
		model.addObject("update", true);
		return model;
	}
	
	@PostMapping("/users/{userId}/updateUser")
	@PreAuthorize("@userSecurity.adminAccess(authentication, #userId)")
	public ModelAndView updateUser(@Valid @ModelAttribute("user")  UserUpdateRequest user, 
			BindingResult result, @PathVariable("userId") Long userId) {
		ModelAndView model = new ModelAndView();
		if(result.hasErrors()) {
			List<Address> addresses = getAllAddressByUserId(userId);
			user.setId(userId);
			model.setViewName("userForm");
			model.addObject("user", user);
			model.addObject("addresses", addresses);
			model.addObject("update", true);
			return model;
		}
		
		User userEntity = userService.updateUser(user, userId);
		
		model.setViewName("user");
		model.addObject("user", userEntity);
		RedirectView redirectView = new RedirectView("/users/"+userId, true);
		model.setView(redirectView);
		
		return model;
	}
	
	@DeleteMapping("/users/{userId}/deleteUser")
	@PreAuthorize("@userSecurity.deleteAccess(authentication, #userId)")
	public ModelAndView deleteUser(@PathVariable("userId") Long userId) {
		userService.deleteUser(userId);
		return null;
	}
	
	public List<Address> getAllAddressByUserId(Long userId){
		return userService.getAllAddressByUserId(userId);
	}
	
}
