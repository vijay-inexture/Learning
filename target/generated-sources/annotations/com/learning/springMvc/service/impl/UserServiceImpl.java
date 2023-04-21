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
		ModelAndView mv = new ModelAndView();
		if(sessionUser==null) {
			session.setAttribute("redirectUrl", "/users");
			mv.setViewName("redirect:/login");
			return mv;
		}
		if(!sessionUser.getRole().equals("ADMIN")) {
			throw new UserAccessDeniedException("Access Denied!");
		}
		List<User> users = userDao.findAll();
		mv.addObject("users", users);
		mv.setViewName("users");
		return mv;
	}

	@Override
	public ModelAndView getUserById(Long userId, HttpSession session) {
		User sessionUser =  (User) session.getAttribute("user");
		ModelAndView mv = new ModelAndView();
		if(sessionUser==null) {
			session.setAttribute("redirectUrl", "/users/"+userId);
			mv.setViewName("redirect:/login");
			return mv;
		}
		User user = userDao.findById(userId);
		if(user==null) {
			throw new UserNotFoundException("User not found!");
		}
		List<Address> addresses = addressDao.findAllByUserId(user.getId());
		user.setAddresses(addresses);
		mv.addObject("user", user);
		mv.setViewName("user");
		return mv;
	}

	@Override
	public ModelAndView updateUser(Long userId, HttpSession session) {
		User sessionUser =  (User) session.getAttribute("user");
		ModelAndView mv = new ModelAndView();
		if(sessionUser==null) {
			session.setAttribute("redirectUrl", "/users/"+userId);
			mv.setViewName("redirect:/login");
			return mv;
		}
		User user = userDao.findById(userId);
		if(user==null) {
			throw new UserNotFoundException("User not found!");
		}
		
		return null;
	}

}
