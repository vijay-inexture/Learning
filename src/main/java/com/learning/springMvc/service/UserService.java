package com.learning.springMvc.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.learning.springMvc.dto.UserUpdateRequest;
import com.learning.springMvc.model.Address;
import com.learning.springMvc.model.User;



public interface UserService {
	
	public User createUser(User user);

	public List<User>  getAllUser();

	public User getUserById(Long userId);

	public User updateUserForm(Long userId, HttpSession session);

	public User updateUser(UserUpdateRequest user,Long userId,  HttpSession session);

	public void deleteUser(Long userId, HttpSession session);

	public List<Address> getAllAddressByUserId(Long userId);

}
