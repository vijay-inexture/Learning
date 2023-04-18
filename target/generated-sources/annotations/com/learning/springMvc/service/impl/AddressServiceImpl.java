package com.learning.springMvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.learning.springMvc.dao.AddressDao;
import com.learning.springMvc.dao.UserDao;
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
	public String createUserAddressForm() {
		return "addressForm";
	}

	@Override
	public String createAddress(Address address, String email) {
		User user = userDao.findByEmail(email);
		if(user==null) {
			throw new RuntimeException("Invalid user");
		}
		address.setUserId(user.getId());
		addressDao.save(address);
		return "addressStatus";
	}

	@Override
	public ModelAndView getAllAddressByUserEmail(String email) {
		User user = userDao.findByEmail(email);
		if(user==null) {
			throw new RuntimeException("Invalid user");
		}
		List<Address> addresses = addressDao.findAllById(user.getId());
		ModelAndView model = new ModelAndView();
		model.setViewName("addresses");
		model.addObject("addresses", addresses);
		return model;
	}
	
	

}
