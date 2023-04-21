package com.learning.springMvc.service.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.learning.springMvc.dao.UserDao;
import com.learning.springMvc.dto.Credential;
import com.learning.springMvc.model.User;
import com.learning.springMvc.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public String loginForm(HttpSession session) {
		Object sessionUser = session.getAttribute("user");
		if(sessionUser!=null) {
			return "redirect:/";
		}
		return "loginForm";
	}

	@Override
	public String login(@ModelAttribute Credential credential, HttpSession session) {
		User user = userDao.findByEmail(credential.getEmail());
		if(user!=null && user.getPassword().equals(credential.getPassword())) {
			session.setAttribute("user", user);
			session.setMaxInactiveInterval(20);
			String redirectUrl = (String) session.getAttribute("redirectUrl");
	        if (redirectUrl != null) {
	            session.removeAttribute("redirectUrl");
	            return "redirect:" + redirectUrl;
	        } else {
	            return "redirect:/";
	        }
		}
		return "redirect:login";
	}

	@Override
	public String logout(HttpSession session) {
		Object sessionUser = session.getAttribute("user");
		if(sessionUser!=null) {
			session.invalidate();
		}
		return "redirect:/login";
	}

	
}
