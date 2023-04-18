package com.learning.springMvc.service;

import org.springframework.web.servlet.ModelAndView;

import com.learning.springMvc.model.Address;

public interface AddressService {

	String createAddress(Address address, String email);

	String createUserAddressForm();

	ModelAndView getAllAddressByUserEmail(String email);

}
