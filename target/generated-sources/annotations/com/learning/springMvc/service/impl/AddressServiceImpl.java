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
import com.learning.springMvc.dto.UserAddress;
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
	public void createUserAddressForm(Long userId) {		
		//check valid userId
		User user = userDao.findById(userId);
		if(user==null) {
			throw new UserNotFoundException("User not found!");
		}
	}

	@Override
	public User createAddress(Address address, Long userId, HttpSession session) {
		//validate userId and admin not allow to update other admin details
		User user = requestValidate(userId, null, session).getUser();
				
		address.setUserId(user.getId());
		addressDao.save(address);
		
		return getUserWithAddresses(user);
	}

	@Override
	public Address upadateUserAddressForm(Long userId, Long addressId, HttpSession session) {
		//validate userId, addressId and admin not allow to update other admin details
		Address address = requestValidate(userId, addressId, session).getAddress();
				
		return address;
	}

	@Override
	public User updateUserAddress(Address address, Long userId, Long addressId,HttpSession session) {
		//validate userId, addressId and admin not allow to update other admin details
		UserAddress userAddress = requestValidate(userId, addressId, session);
		Address addressEntity = userAddress.getAddress();
		User user = userAddress.getUser();
		
		addressEntity.setStreet(address.getStreet());
		addressEntity.setCity(address.getCity());
		addressDao.updateAddress(addressEntity);
		
		return getUserWithAddresses(user);
	}

	@Override
	public User deleteUserAddress(Long userId, Long addressId,HttpSession session) {
		//validate userId,addressId and admin not allow to update other admin details
		User user = requestValidate(userId, addressId, session).getUser();
		
		addressDao.deleteById(addressId);
		
		return getUserWithAddresses(user);
	}

	private UserAddress requestValidate(Long userId, Long addressId, HttpSession session) {
		//check valid userId
		User user = userDao.findById(userId);
		if(user==null) {
			throw new UserNotFoundException("User not found!");
		}

		//admin not allow to update other admin details
		User sessionUser =  (User) session.getAttribute("user");
		if(user.getRole().equals("ADMIN") && !sessionUser.getId().equals(user.getId())) {
			throw new UserAccessDeniedException("Access Denied!");
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
