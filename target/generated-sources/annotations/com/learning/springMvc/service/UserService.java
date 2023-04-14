package com.learning.springMvc.service;

import java.util.List;

import com.learning.springMvc.model.User;


public interface UserService {
	
	public void createUser(User user);

	public List<User> getAllUser();

	public User getUserByEmail(String email);

}
