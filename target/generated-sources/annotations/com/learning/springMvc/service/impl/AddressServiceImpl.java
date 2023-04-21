package com.learning.springMvc.service.impl;

import java.nio.file.AccessDeniedException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.learning.springMvc.dao.AddressDao;
import com.learning.springMvc.dao.UserDao;
import com.learning.springMvc.exception.AddressNotFoundException;
import com.learning.springMvc.exception.UserAccessDeniedException;
import com.learning.springMvc.exception.UserNotFoundException;
import com.learning.springMvc.model.Address;
import com.learning.springMvc.model.User;
import com.learning.springMvc.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private AddressDao addressDao;
	
	@Override
	public String createUserAddressForm(Long userId, HttpSession session) {
		User sessionUser =  (User) session.getAttribute("user");
		if(sessionUser==null) {
			session.setAttribute("redirectUrl", "/users/"+userId+"/addressForm");
			return "redirect:/login";
		}
		User user = userDao.findById(userId);
		if(user==null) {
			throw new UserNotFoundException("Invalid user");
		}
		return "addressForm";
	}

	@Override
	public ModelAndView createAddress(Address address, Long userId,HttpServletRequest request, HttpSession session) {
		User sessionUser =  (User) session.getAttribute("user");
		ModelAndView model = new ModelAndView();
		if(sessionUser==null) {
			session.setAttribute("redirectUrl", "/users/"+userId);
			model.setViewName("redirect:/login");
			return model;
		}
		if(!sessionUser.getId().equals(userId)) {
			throw new UserAccessDeniedException("Access Denied!");
		}
		User user = userDao.findById(userId);
		if(user==null) {
			throw new UserNotFoundException("Invalid user");
		}
		address.setUserId(user.getId());
		addressDao.save(address);
		
		model = showUserDetails(user, request);
		return model;
	}

	
	@Override
	public ModelAndView upadateUserAddressForm(Long userId, Long addressId, HttpSession session) {
		User sessionUser =  (User) session.getAttribute("user");
		ModelAndView model = new ModelAndView();
		if(sessionUser==null) {
			session.setAttribute("redirectUrl", "/users/"+userId+"/address/"+addressId);
			model.setViewName("redirect:/login");
			return model;
		}
		User user = userDao.findById(userId);
		if(user==null) {
			throw new UserNotFoundException("Invalid user");
		}
		Address address = addressDao.findById(addressId);
		if(address==null) {
			throw new AddressNotFoundException("Address not found!");
		}
		model.setViewName("updateAddressForm");
		model.addObject("address", address);
		return model;
	}

	@Override
	public ModelAndView updateUserAddress(Address address, Long userId, Long addressId,HttpServletRequest request, HttpSession session) {
		User sessionUser =  (User) session.getAttribute("user");
		ModelAndView model = new ModelAndView();
		if(sessionUser==null) {
			session.setAttribute("redirectUrl", "/users/"+userId);
			model.setViewName("redirect:/login");
			return model;
		}
		if(!sessionUser.getId().equals(userId)) {
			throw new UserAccessDeniedException("Access Denied!");
		}
		User user = userDao.findById(userId);
		if(user==null) {
			throw new UserNotFoundException("Invalid user");
		}
		Address addressEntity = addressDao.findById(addressId);
		if(addressEntity==null) {
			throw new AddressNotFoundException("Address not found!");
		}
		addressEntity.setStreet(address.getStreet());
		addressEntity.setCity(address.getCity());
		addressDao.updateAddress(addressEntity);
		
		model = showUserDetails(user, request);
		return model;
	}

	@Override
	public ModelAndView deleteUserAddress(Long userId, Long addressId,HttpServletRequest request, HttpSession session) {
		User sessionUser =  (User) session.getAttribute("user");
		ModelAndView model = new ModelAndView();
		if(sessionUser==null) {
			session.setAttribute("redirectUrl", "/users/"+userId);
			model.setViewName("redirect:/login");
			return model;
		}
		if(!sessionUser.getId().equals(userId)) {
			throw new UserAccessDeniedException("Access Denied!");
		}
		User user = userDao.findById(userId);
		if(user==null) {
			throw new UserNotFoundException("Invalid user");
		}
		Address addressEntity = addressDao.findById(addressId);
		if(addressEntity==null) {
			throw new AddressNotFoundException("Address not found!");
		}
		addressDao.deleteById(addressId);
		
		model = showUserDetails(user, request);
		return model;
	}

	private ModelAndView showUserDetails(User user, HttpServletRequest request) {
    	ModelAndView model = new ModelAndView();
    	List<Address> addresses = addressDao.findAllByUserId(user.getId());
		user.setAddresses(addresses);
		model.setViewName("user");
		model.addObject("user",user);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/users/"+user.getId());
		model.setView(redirectView);
		return model;
	}

}
