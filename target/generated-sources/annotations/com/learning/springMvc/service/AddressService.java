package com.learning.springMvc.service;

import java.nio.file.AccessDeniedException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.learning.springMvc.model.Address;

public interface AddressService {

	String createUserAddressForm(Long userId, HttpSession session);
	
	ModelAndView createAddress(Address address, Long userId,HttpServletRequest request, HttpSession session);
	
	ModelAndView upadateUserAddressForm(Long userId,Long addressId, HttpSession session);

	ModelAndView updateUserAddress(Address address, Long userId, Long addressId,HttpServletRequest request, HttpSession session);

	ModelAndView deleteUserAddress(Long userId, Long addressId,HttpServletRequest request, HttpSession session);

}
