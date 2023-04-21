package com.learning.springMvc.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.learning.springMvc.dao.AddressDao;
import com.learning.springMvc.dao.UserDao;
import com.learning.springMvc.exception.UserAccessDeniedException;
import com.learning.springMvc.exception.UserNotFoundException;
import com.learning.springMvc.model.Address;
import com.learning.springMvc.model.User;
import com.learning.springMvc.service.UserService;

import jakarta.validation.Valid;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private AddressDao addressDao;
	
	@Override
	public String userForm() {
		return "userForm";
	}

	@Override
	public ModelAndView createUser(User user) {
		User userByEmail = userDao.findByEmail(user.getEmail());
		if(userByEmail!=null) {
			throw new RuntimeException("User already exist with email!");
		}
		userDao.save(user);
		User userEntity = userDao.findByEmail(user.getEmail());
		ModelAndView model = new ModelAndView();
		model.setViewName("userStatus");
		model.addObject("userId", userEntity.getId());
		return model;
	}

	@Override
	public ModelAndView getAllUser(HttpSession session) {
		User sessionUser =  (User) session.getAttribute("user");
		ModelAndView model = new ModelAndView();
		if(sessionUser==null) {
			session.setAttribute("redirectUrl", "/users");
			model.setViewName("redirect:/login");
			return model;
		}
		if(!sessionUser.getRole().equals("ADMIN")) {
			throw new UserAccessDeniedException("Access Denied!");
		}
		List<User> users = userDao.findAll();
		model.addObject("users", users);
		model.setViewName("users");
		return model;
	}

	@Override
	public ModelAndView getUserById(Long userId, HttpSession session) {
		User sessionUser =  (User) session.getAttribute("user");
		ModelAndView model = new ModelAndView();
		if(sessionUser==null) {
			session.setAttribute("redirectUrl", "/users/"+userId);
			model.setViewName("redirect:/login");
			return model;
		}
		User user = userDao.findById(userId);
		if(user==null) {
			throw new UserNotFoundException("User not found!");
		}
		List<Address> addresses = addressDao.findAllByUserId(user.getId());
		user.setAddresses(addresses);
		model.addObject("user", user);
		model.setViewName("user");
		return model;
	}

	@Override
	public ModelAndView updateUserFrom(Long userId, HttpSession session) {
		User sessionUser =  (User) session.getAttribute("user");
		ModelAndView model = new ModelAndView();
		if(sessionUser==null) {
			session.setAttribute("redirectUrl", "/users/"+userId);
			model.setViewName("redirect:/login");
			return model;
		}
		User user = userDao.findById(userId);
		if(user==null) {
			throw new UserNotFoundException("User not found!");
		}
		model.setViewName("updateUserForm");
		List<Address> addresses = addressDao.findAllByUserId(user.getId());
		user.setAddresses(addresses);
		model.addObject("user", user);
		return model;
	}

	@Override
	public ModelAndView updateUser(@Valid User user, Long userId, HttpSession session) {
		//check session user login or not
		User sessionUser =  (User) session.getAttribute("user");
		ModelAndView model = new ModelAndView();
		if(sessionUser==null) {
			session.setAttribute("redirectUrl", "/users/"+userId);
			model.setViewName("redirect:/login");
			return model;
		}
		
		//check user has access to update 
		if(!(sessionUser.getRole().equals("ADMIN") || sessionUser.getId().equals(userId))){
			throw new UserAccessDeniedException("Access Denied!");
		}
		
		//check if user exist with userId
		User userEntity = userDao.findById(userId);
		if(userEntity==null) {
			throw new UserNotFoundException("User not found!");
		}
		userEntity.setName(user.getName());
		
		//check if user changed email
		if(!user.getEmail().equals(userEntity.getEmail())) {
			User userByEmail = userDao.findByEmail(user.getEmail());
			if(userByEmail!=null) {
				throw new RuntimeException("User Already Exist!");
			}
		}
		userEntity.setEmail(user.getEmail());
		userDao.update(userEntity);
		
		model.setViewName("user");
		List<Address> addresses = addressDao.findAllByUserId(user.getId());
		userEntity.setAddresses(addresses);
		model.addObject("user", userEntity);
		return model;
	}

}
