package com.learning.springMvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.springMvc.dao.AddressDao;
import com.learning.springMvc.dao.UserDao;
import com.learning.springMvc.dto.UserAddress;
import com.learning.springMvc.exception.AddressNotFoundException;
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
	public void createUserAddressForm(Long userId) {		
		//check valid userId
		User user = userDao.findById(userId);
		if(user==null) {
			throw new UserNotFoundException("User not found!");
		}
	}

	@Override
	public User createAddress(Address address, Long userId) {
		//validate userId
		User user = requestValidate(userId, null).getUser();
				
		address.setUser(user);
		addressDao.save(address);
		
		return getUserWithAddresses(user);
	}

	@Override
	public Address upadateUserAddressForm(Long userId, Long addressId) {
		//validate userId and addressId
		Address address = requestValidate(userId, addressId).getAddress();
				
		return address;
	}

	@Override
	public User updateUserAddress(Address address, Long userId, Long addressId) {
		//validate userId and addressId
		UserAddress userAddress = requestValidate(userId, addressId);
		Address addressEntity = userAddress.getAddress();
		User user = userAddress.getUser();
		
		addressEntity.setStreet(address.getStreet());
		addressEntity.setCity(address.getCity());
		addressDao.updateAddress(addressEntity);
		
		return getUserWithAddresses(user);
	}

	@Override
	public User deleteUserAddress(Long userId, Long addressId) {
		//validate userId and addressId
		User user = requestValidate(userId, addressId).getUser();
		
		addressDao.deleteById(addressId);
		
		return getUserWithAddresses(user);
	}

	private UserAddress requestValidate(Long userId, Long addressId) {
		//check valid userId
		User user = userDao.findById(userId);
		if(user==null) {
			throw new UserNotFoundException("User not found!");
		}
		
		UserAddress userAddress = new UserAddress();
		
		//check valid addressId
		if(addressId!=null) {
			Address address = addressDao.findById(addressId);
			if(address==null) {
				throw new AddressNotFoundException("Address not found!");
			}
			userAddress.setAddress(address);
		}
		userAddress.setUser(user);
		return userAddress;
	}
	
	private User getUserWithAddresses(User user) {
		List<Address> addresses = addressDao.findAllByUserId(user.getId());
		user.setAddresses(addresses);
		return user;
	}
}
