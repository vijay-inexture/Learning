package com.learning.springMvc.dao;

import java.util.List;

import com.learning.springMvc.model.User;

public interface UserDao {
	
	public List<User> findAll();
	public void save(User user);
	public void update(User user);
	public User findByEmail(String email);
	public User findById(Long userId);
	public void deleteById(Long userId);
	public void updatePassword(String email, String newPassword);
}
