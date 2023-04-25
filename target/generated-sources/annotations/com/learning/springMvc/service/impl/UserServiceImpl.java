package com.learning.springMvc.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.ModelAndView;

import com.learning.springMvc.dao.AddressDao;
import com.learning.springMvc.dao.UserDao;
import com.learning.springMvc.exception.UserAccessDeniedException;
import com.learning.springMvc.exception.UserAlreadyExistException;
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
	public User createUser(User user) {		
		//check if user email is already exist 
		User userByEmail = userDao.findByEmail(user.getEmail());
		if(userByEmail!=null) {
			throw new UserAlreadyExistException("User already exist with email!");
		}
		user.setRole("USER");
		userDao.save(user);
		
		User userEntity = userDao.findByEmail(user.getEmail());
		return userEntity;
	}

	@Override
	public List<User> getAllUser() {
		return  userDao.findAll();
	}

	@Override
	public User getUserById(Long userId) {		
		//userId is valid or not
		User user = userDao.findById(userId);
		if(user==null) {
			throw new UserNotFoundException("User not found!");
		}
		
		List<Address> addresses = addressDao.findAllByUserId(user.getId());
		user.setAddresses(addresses);
		return user;
	}

	@Override
	public User updateUserForm(Long userId, HttpSession session) {
		//check userId is valid
		User user = userDao.findById(userId);
		if(user==null) {
			throw new UserNotFoundException("User not found!");
		}
		

		//admin can not update other admin details
		User sessionUser =  (User) session.getAttribute("user");
		if(user.getRole().equals("ADMIN") && !sessionUser.getId().equals(user.getId())) {
			throw new UserAccessDeniedException("Access Denied!");
		}
		
		List<Address> addresses = addressDao.findAllByUserId(user.getId());
		user.setAddresses(addresses);
		return user;
		
	}

	@Override
	public User updateUser(User user, Long userId, HttpSession session) {
		//check if user exist with userId
		User userEntity = userDao.findById(userId);
		if(userEntity==null) {
			throw new UserNotFoundException("User not found!");
		}
		
		//admin can not update other admin details
		User sessionUser =  (User) session.getAttribute("user");
		if(userEntity.getRole().equals("ADMIN") && !sessionUser.getId().equals(userEntity.getId())) {
			throw new UserAccessDeniedException("Access Denied!");
		}
		
		userEntity.setName(user.getName());
		//check if user changed email
		if(!user.getEmail().equals(userEntity.getEmail())) {
			User userByEmail = userDao.findByEmail(user.getEmail());
			if(userByEmail!=null) {
				throw new UserAlreadyExistException("User Already Exist!");
			}
		}
		
		userEntity.setEmail(user.getEmail());
		userDao.update(userEntity);
		
		List<Address> addresses = addressDao.findAllByUserId(userId);
		userEntity.setAddresses(addresses);
		return userEntity;		
	}

	@Override
	@Transactional
	public void deleteUser(Long userId, HttpSession session) {
		//check if user exist with userId
		User userEntity = userDao.findById(userId);
		if(userEntity==null) {
			throw new UserNotFoundException("User not found!");
		}

		//admin can not delete other admin or self
		if(userEntity.getRole().equals("ADMIN") && userEntity.getId().equals(userId)) {
			throw new UserAccessDeniedException("Access Denied!");
		}
		
		addressDao.deleteAllByUserId(userId);
		//throwing exception to check @transactional working
//		if(userId!=null) {
//			throw new RuntimeException("Error");
//		}
		userDao.deleteById(userId);
	}

}
