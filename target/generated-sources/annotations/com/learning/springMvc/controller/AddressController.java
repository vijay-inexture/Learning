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

import com.learning.springMvc.model.Address;
import com.learning.springMvc.service.AddressService;

import jakarta.validation.Valid;

@Controller
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@GetMapping("/users/{userId}/address")
	public String createUserAddressForm(@PathVariable Long userId,HttpSession session){
		return addressService.createUserAddressForm(userId, session);
	}
	
	@PostMapping("/users/{userId}/address")
	public ModelAndView createAddress(@Valid @ModelAttribute Address address, @PathVariable Long userId,HttpServletRequest request, HttpSession session) {
		return addressService.createAddress(address,userId, request, session);
	}
	
	@GetMapping("/users/{userId}/address/{addressId}")
	public ModelAndView upadateUserAddressForm(@PathVariable Long userId,@PathVariable Long addressId,HttpSession session){
		return addressService.upadateUserAddressForm(userId, addressId, session);
	}
	
	@PostMapping("/users/{userId}/address/{addressId}")
	public ModelAndView updateUserAddress(@Valid @ModelAttribute Address address, @PathVariable Long userId, @PathVariable Long addressId,HttpServletRequest request, HttpSession session) {
		return addressService.updateUserAddress(address, userId, addressId,request, session);
	}
	
	@GetMapping("/users/{userId}/address/{addressId}/delete")
	public ModelAndView deleteUserAddress(@PathVariable Long userId, @PathVariable Long addressId,HttpServletRequest request, HttpSession session) {
		return addressService.deleteUserAddress(userId, addressId,request, session);
	}
	
	
}
