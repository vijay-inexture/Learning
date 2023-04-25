package com.learning.springMvc.service;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import com.learning.springMvc.model.User;



public interface UserService {
	
	public User createUser(User user);

	public List<User>  getAllUser();

	public User getUserById(Long userId);

	public User updateUserForm(Long userId, HttpSession session);

	public User updateUser(User user,Long userId,  HttpSession session);

	public void deleteUser(Long userId, HttpSession session);

}
