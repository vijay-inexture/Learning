package com.learning.springMvc.service;

import javax.servlet.http.HttpSession;

import com.learning.springMvc.model.Address;
import com.learning.springMvc.model.User;

public interface AddressService {

	void createUserAddressForm(Long userId);
	
	User createAddress(Address address, Long userId, HttpSession session);
	
	Address upadateUserAddressForm(Long userId,Long addressId, HttpSession session);

	User updateUserAddress(Address address, Long userId, Long addressId,HttpSession session);

	User deleteUserAddress(Long userId, Long addressId,HttpSession session);

}