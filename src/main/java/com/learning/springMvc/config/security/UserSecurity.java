package com.learning.springMvc.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.learning.springMvc.dao.UserDao;
import com.learning.springMvc.exception.UserNotFoundException;
import com.learning.springMvc.model.User;

@Component("userSecurity")
public class UserSecurity {
	
	@Autowired
	private UserDao userDao;
	
	
	//Admin or same user can access
	public boolean userAccess(Authentication authentication, Long userId) {
		Long id = userDao.findByEmail(authentication.getName()).getId();
		boolean hasAdminRole = authentication.getAuthorities().stream()
		          .anyMatch(r -> r.getAuthority().equals("ADMIN"));
		if(id.equals(userId) || hasAdminRole)
			return true;
		return false;
	}
	
	//Admin and same user can update but admin can update other admin
	public boolean adminAccess(Authentication authentication, Long userId) {
		Long id = userDao.findByEmail(authentication.getName()).getId();
		User editUser = userDao.findById(userId);
		
		if(editUser==null) {
			throw new UserNotFoundException("User not found");
		}
		boolean editUserIsAdmin = editUser.getRole().equals("ADMIN");
		boolean hasAdminRole = authentication.getAuthorities().stream()
		          .anyMatch(r -> r.getAuthority().equals("ADMIN"));
		
		if(editUserIsAdmin && !id.equals(userId)) {
			return false;
		}else if(id.equals(userId) || hasAdminRole) {
			return true;
		}
		return false;
	}
	
	//admin can not detele admin not even himself
	public boolean deleteAccess(Authentication authentication, Long userId) {
		User deleteUser = userDao.findById(userId);
		if(deleteUser==null) {
			throw new UserNotFoundException("User not found");
		}
		boolean deleteUserIsAdmin = deleteUser.getRole().equals("ADMIN");
		if(deleteUserIsAdmin) 
			return false;
		return true;
	}

}
