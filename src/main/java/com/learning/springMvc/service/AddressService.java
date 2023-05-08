package com.learning.springMvc.service;

import com.learning.springMvc.model.Address;
import com.learning.springMvc.model.User;

public interface AddressService {

	void createUserAddressForm(Long userId);
	
	User createAddress(Address address, Long userId);
	
	Address upadateUserAddressForm(Long userId,Long addressId);

	User updateUserAddress(Address address, Long userId, Long addressId);

	User deleteUserAddress(Long userId, Long addressId);

}
