package com.learning.springMvc.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.learning.springMvc.model.User;


public interface UserService {
	
	public String userForm();
	
	public ModelAndView createUser(User user);

	public ModelAndView getAllUser(HttpSession session);

	public ModelAndView getUserById(Long userId, HttpSession session);

	public ModelAndView updateUser(Long userId, HttpSession session);

}
