package com.learning.springMvc.controller;

import java.nio.file.AccessDeniedException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.learning.springMvc.exception.UserAccessDeniedException;
import com.learning.springMvc.model.Address;
import com.learning.springMvc.model.User;
import com.learning.springMvc.service.AddressService;

import jakarta.validation.Valid;


@Controller
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@GetMapping("/users/{userId}/address")
	public String createUserAddressForm(@PathVariable Long userId,HttpSession session){
		User sessionUser =  (User) session.getAttribute("user");
		if(sessionUser==null) {
			session.setAttribute("redirectUrl", "/users/"+userId+"/addressForm");
			return "redirect:/login";
		}
		addressService.createUserAddressForm(userId);
		return "addressForm";
	}
	
	@PostMapping("/users/{userId}/address")
	public ModelAndView createAddress(@Valid @ModelAttribute Address address, @PathVariable Long userId, HttpSession session) {
		Object redirect = sessionUserValidate(userId, session);
		if(redirect!=null) {
			return (ModelAndView) redirect;
		}
		
		User user = addressService.createAddress(address,userId, session);
		
		return commonResponse(user);
	}
	

	@GetMapping("/users/{userId}/address/{addressId}")
	public ModelAndView upadateUserAddressForm(@PathVariable Long userId,@PathVariable Long addressId,HttpSession session){
		Object redirect = sessionUserValidate(userId, session);
		if(redirect!=null) {
			return (ModelAndView) redirect;
		}
		
		Address address = addressService.upadateUserAddressForm(userId, addressId, session);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("updateAddressForm");
		model.addObject("address", address);
		return model;
	}
	
	@PostMapping("/users/{userId}/address/{addressId}")
	public ModelAndView updateUserAddress(@Valid @ModelAttribute Address address, @PathVariable Long userId, @PathVariable Long addressId,HttpSession session) {
		Object redirect = sessionUserValidate(userId, session);
		if(redirect!=null) {
			return (ModelAndView) redirect;
		}
		
		User user = addressService.updateUserAddress(address, userId, addressId, session);
		
		return commonResponse(user);	
	}
	
	@DeleteMapping("/users/{userId}/address/{addressId}")
	public ModelAndView deleteUserAddress(@PathVariable Long userId, @PathVariable Long addressId,HttpSession session) {
		Object redirect = sessionUserValidate(userId, session);
		if(redirect!=null) {
			return (ModelAndView) redirect;
		}
		
		User user = addressService.deleteUserAddress(userId, addressId, session);
		
		return null;
	}

	private Object sessionUserValidate(Long userId, HttpSession session) {
		User sessionUser =  (User) session.getAttribute("user");
		ModelAndView model = new ModelAndView();
		if(sessionUser==null) {
			session.setAttribute("redirectUrl", "/users/"+userId+"/updateUser");
			model.setViewName("redirect:/login");
			return model;
		}
		
		//check permission
		if(!(sessionUser.getRole().equals("ADMIN") || sessionUser.getId().equals(userId))) {
			throw new UserAccessDeniedException("Access Denied!");
		}
		
		return null;
	}
	
	private ModelAndView commonResponse(User user) {
		ModelAndView model = new ModelAndView();
		model.addObject("user", user);
		model.setViewName("updateUserForm");
		RedirectView redirectView = new RedirectView("/users/"+user.getId()+"/updateUser", true);
		model.setView(redirectView);
		return model;
	}
}
