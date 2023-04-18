package com.learning.springMvc.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.learning.springMvc.model.User;


public interface UserService {
	
	public String home();
	
	public String userForm();
	
	public String createUser(User user);

	public ModelAndView getAllUser();

	public ModelAndView getUserByEmail(String email);

	public ModelAndView getUserById(Long userId);

}
