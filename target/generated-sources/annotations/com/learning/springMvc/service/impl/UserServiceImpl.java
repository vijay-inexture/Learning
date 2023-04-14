package com.learning.springMvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.springMvc.dao.UserDao;
import com.learning.springMvc.model.User;
import com.learning.springMvc.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public void createUser(User user) {
		userDao.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userDao.findAll();
	}

	@Override
	public User getUserByEmail(String email) {
		return userDao.findByEmail(email);
	}

}
