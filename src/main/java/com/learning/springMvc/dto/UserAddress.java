package com.learning.springMvc.dto;

import com.learning.springMvc.model.Address;
import com.learning.springMvc.model.User;

public class UserAddress {
	
	private User user;
	private Address address;
	
	public UserAddress() {
		super();
	}

	public UserAddress(User user, Address address) {
		super();
		this.user = user;
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}
