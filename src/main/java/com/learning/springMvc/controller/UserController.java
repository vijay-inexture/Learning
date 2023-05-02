package com.learning.springMvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.learning.springMvc.exception.UserAccessDeniedException;
import com.learning.springMvc.model.User;
import com.learning.springMvc.service.UserService;


@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/userform")
	public String createUserForm() {
		return "userForm";
	}
	
	@PostMapping("/users")
	public ModelAndView createUser(@Valid @ModelAttribute("user")  User user, BindingResult result) {
		ModelAndView model = new ModelAndView();
		if (result.hasErrors()) {
			model.setViewName("userForm");
//			model.addObject("user", user);
			return model;
		}
	
		User userEntity = userService.createUser(user);
		
		model.setViewName("userStatus");
		model.addObject("userId", userEntity.getId());
		return model;
	}

	@GetMapping("/users")
	public ModelAndView getAllUser(HttpSession session) {
		//check session for login
		User sessionUser =  (User) session.getAttribute("user");
		ModelAndView model = new ModelAndView();
		if(sessionUser==null) {
			session.setAttribute("redirectUrl", "/users");
			model.setViewName("redirect:/login");
			return model;
		}
		
		//check permission
		if(!sessionUser.getRole().equals("ADMIN")) {
			throw new UserAccessDeniedException("Access Denied!");
		}
		
		List<User> users = userService.getAllUser();
		
		model.addObject("users", users);
		model.setViewName("users");
		return model;
	}
	
	@GetMapping("/users/{userId}")
	public ModelAndView getUserById(@PathVariable("userId") Long userId,HttpSession session) {
		//check session for login
		User sessionUser =  (User) session.getAttribute("user");
		ModelAndView model = new ModelAndView();
		if(sessionUser==null) {
			session.setAttribute("redirectUrl", "/users/"+userId);
			model.setViewName("redirect:/login");
			return model;
		}
		
		//check permission
		if(!(sessionUser.getRole().equals("ADMIN") || sessionUser.getId().equals(userId))){
			throw new UserAccessDeniedException("Access Denied!");
		}
		
		User user = userService.getUserById(userId);
		
		model.addObject("user", user);
		model.setViewName("user");
		return model;
	}
	
	@GetMapping("/users/{userId}/updateUser")
	public ModelAndView  updateUserForm(@PathVariable("userId") Long userId,HttpSession session) {
		//check session for login
		User sessionUser =  (User) session.getAttribute("user");
		ModelAndView model = new ModelAndView();
		if(sessionUser==null) {
			session.setAttribute("redirectUrl", "/users/"+userId+"/updateUser");
			model.setViewName("redirect:/login");
			return model;
		}
		
		User user = userService.updateUserForm(userId, session);
		
		model.setViewName("userForm");
		model.addObject("user", user);
		model.addObject("update", true);
		return model;
	}
	
	@PostMapping("/users/{userId}/updateUser")
	public ModelAndView updateUser(@Valid @ModelAttribute  UserUpdateRequest user, BindingResult result, @PathVariable("userId") Long userId, HttpSession session) {
		ModelAndView model = new ModelAndView();
		if(result.hasErrors()) {
			model.setViewName("userForm");
			User userFromModel = (User) getUserById(userId, session).getModel().get("user");
			model.addObject("user", userFromModel);
			model.addObject("update", true);
			return model;
		}
		//check session for login
		User sessionUser =  (User) session.getAttribute("user");
		if(sessionUser==null) {
			session.setAttribute("redirectUrl", "/users/"+userId+"/updateUser");
			model.setViewName("redirect:/login");
			return model;
		}
		
		//check user has access to update 
		if(!(sessionUser.getRole().equals("ADMIN") || sessionUser.getId().equals(userId))){
			throw new UserAccessDeniedException("Access Denied!");
		}
		
		User userEntity = userService.updateUser(user, userId, session);
		
		model.setViewName("user");
		model.addObject("user", userEntity);
		RedirectView redirectView = new RedirectView("/users/"+userId, true);
		model.setView(redirectView);
		
		return model;
	}
	
	@DeleteMapping("/users/{userId}/deleteUser")
	public ModelAndView deleteUser(@PathVariable("userId") Long userId,HttpSession session) {
		//check session for login
		User sessionUser =  (User) session.getAttribute("user");
		ModelAndView model = new ModelAndView();
		if(sessionUser==null) {
			session.setAttribute("redirectUrl", "/users/"+userId);
			model.setViewName("redirect:/login");
			return model;
		}
		
		//check user has access to delete 
		if(!sessionUser.getRole().equals("ADMIN")){
			throw new UserAccessDeniedException("Access Denied!");
		}
		userService.deleteUser(userId, session);
		return null;
	}
	
}
