package com.learning.springMvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.learning.springMvc.dao.UserDao;
import com.learning.springMvc.exception.UserNotFoundException;
import com.learning.springMvc.model.User;

@Component
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByEmail(username);
		if(user==null) {
			throw new UserNotFoundException("user not found with username : "+username);
		}
		CustomUserDetails userDetails = new CustomUserDetails(user);
		return userDetails;
	}

}
