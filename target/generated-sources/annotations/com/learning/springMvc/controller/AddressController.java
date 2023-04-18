package com.learning.springMvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.learning.springMvc.model.Address;
import com.learning.springMvc.service.AddressService;

@Controller
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@GetMapping("/user/{email}/address")
	public String createUserAddressForm(){
		return addressService.createUserAddressForm();
	}
	
	@PostMapping("/user/{email}/address")
	public String createAddress(@ModelAttribute Address address, @PathVariable String email) {
		return addressService.createAddress(address,email);
	}
	
	@GetMapping("/user/{email}/address/all")
	public ModelAndView getAllAddressByUserEmail(@PathVariable String email) {
		return addressService.getAllAddressByUserEmail(email);
	} 
	

}
