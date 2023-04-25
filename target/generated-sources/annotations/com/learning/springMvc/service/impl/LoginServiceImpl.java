package com.learning.springMvc.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.learning.springMvc.dao.UserDao;
import com.learning.springMvc.dto.Credential;
import com.learning.springMvc.dto.PasswordReset;
import com.learning.springMvc.exception.UserNotFoundException;
import com.learning.springMvc.model.User;
import com.learning.springMvc.service.LoginService;

import jakarta.validation.Valid;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public String login(@ModelAttribute Credential credential, HttpSession session) {
		User user = userDao.findByEmail(credential.getEmail());
		if(user!=null && user.getPassword().equals(credential.getPassword())) {
			session.setAttribute("user", user);
			session.setMaxInactiveInterval(60*60);
			String redirectUrl = (String) session.getAttribute("redirectUrl");
	        if (redirectUrl != null) {
	            session.removeAttribute("redirectUrl");
	            return "redirect:" + redirectUrl;
	        } else {
	            return "redirect:/users/"+user.getId();
	        }
		}
		return "redirect:login";
	}

	@Override
	public Map<String, Boolean> forgotPassword(@Valid PasswordReset passwordReset) {
		Map<String, Boolean> errors = new HashMap<String, Boolean>();
		errors.put("email", false);
		errors.put("password", false);
		errors.put("confirmPassword", false);
		User user = userDao.findByEmail(passwordReset.getEmail());
		if(user==null) {
//			errors.put("email", true);
			throw new UserNotFoundException("User not exist with Email");
		}
		if(!user.getPassword().equals(passwordReset.getPassword())) {
//			errors.put("password", true);
			throw new RuntimeException("Invalid Password");
		}
		if(!passwordReset.getNewPassword().equals(passwordReset.getConfirmPassword())) {
//			errors.put("confirmPassword", true);
			throw new RuntimeException("New Password and ConfirmPassword Must be same");
		}
		userDao.updatePassword(passwordReset.getEmail(), passwordReset.getNewPassword());
		return errors;
	}

	
}
