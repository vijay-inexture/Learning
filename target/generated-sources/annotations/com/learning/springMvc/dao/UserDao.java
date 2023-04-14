package com.learning.springMvc.dao;

import java.util.List;

import com.learning.springMvc.model.User;

public interface UserDao {
	
	public User findById(Long id);
	public List<User> findAll();
	public void save(User user);
	public void update(User user);
	public void delete(long id);
}
