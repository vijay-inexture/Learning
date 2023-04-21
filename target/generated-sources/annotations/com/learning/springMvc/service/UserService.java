package com.learning.springMvc.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.learning.springMvc.model.User;

import jakarta.validation.Valid;


public interface UserService {
	
	public String userForm();
	
	public ModelAndView createUser(User user);

	public ModelAndView getAllUser(HttpSession session);

	public ModelAndView getUserById(Long userId, HttpSession session);

	public ModelAndView updateUserFrom(Long userId, HttpSession session);

	public ModelAndView updateUser(@Valid User user,Long userId,  HttpSession session);

}
