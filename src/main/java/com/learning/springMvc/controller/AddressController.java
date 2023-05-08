package com.learning.springMvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.learning.springMvc.model.Address;
import com.learning.springMvc.model.User;
import com.learning.springMvc.service.AddressService;

@Controller
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@GetMapping("/users/{userId}/address")
	public String createUserAddressForm(@PathVariable Long userId){
		addressService.createUserAddressForm(userId);
		return "addressForm";
	}
	
	@PostMapping("/users/{userId}/address")
	@PreAuthorize("@userSecurity.adminAccess(authentication, #userId)")
	public ModelAndView createAddress(@Valid @ModelAttribute Address address,BindingResult result, @PathVariable Long userId) {
		ModelAndView model = new ModelAndView();
		if(result.hasErrors()) {
			model.setViewName("addressForm");
			return model;
		}
		
		User user = addressService.createAddress(address,userId);
		
		return commonResponse(user);
	}
	

	@GetMapping("/users/{userId}/address/{addressId}")
	@PreAuthorize("@userSecurity.adminAccess(authentication, #userId)")
	public ModelAndView upadateUserAddressForm(@PathVariable Long userId,@PathVariable Long addressId){		
		Address address = addressService.upadateUserAddressForm(userId, addressId);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("addressForm");
		model.addObject("address", address);
		return model;
	}
	
	@PostMapping("/users/{userId}/address/{addressId}")
	@PreAuthorize("@userSecurity.adminAccess(authentication, #userId)")
	public ModelAndView updateUserAddress(@Valid @ModelAttribute Address address,BindingResult result, 
			@PathVariable Long userId, @PathVariable Long addressId) {
		ModelAndView model = new ModelAndView();
		if(result.hasErrors()) {
			model.setViewName("addressForm");
			return model;
		}
		
		User user = addressService.updateUserAddress(address, userId, addressId);
		
		return commonResponse(user);	
	}
	
	@DeleteMapping("/users/{userId}/address/{addressId}")
	@PreAuthorize("@userSecurity.adminAccess(authentication, #userId)")
	public ModelAndView deleteUserAddress(@PathVariable Long userId, @PathVariable Long addressId) {		
		addressService.deleteUserAddress(userId, addressId);
		
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
