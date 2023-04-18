package com.learning.springMvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.learning.springMvc.dao.UserDao;
import com.learning.springMvc.model.User;
import com.learning.springMvc.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public String home() {
		return "home";
	}
	
	@Override
	public String userForm() {
		return "userForm";
	}

	@Override
	public String createUser(User user) {
		User userByEmail = userDao.findByEmail(user.getEmail());
		if(userByEmail!=null) {
			throw new RuntimeException("User already exist with email!");
		}
		userDao.save(user);
		return "userStatus";
	}

	@Override
	public ModelAndView getAllUser() {
		List<User> users = userDao.findAll();
		ModelAndView mv = new ModelAndView();
		users.forEach(user -> System.out.println(user.getName()));
		mv.addObject("users", users);
		mv.setViewName("users");
		return mv;
	}

	@Override
	public ModelAndView getUserByEmail(String email) {
		User user = userDao.findByEmail(email);
		if(user==null) {
			throw new RuntimeException("User not found!");
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);
		mv.setViewName("user");
		return mv;
	}

	@Override
	public ModelAndView getUserById(Long userId) {
		User user = userDao.findById(userId);
		if(user==null) {
			throw new RuntimeException("User not found!");
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);
		mv.setViewName("user");
		return mv;
	}

}
