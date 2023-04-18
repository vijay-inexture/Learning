package com.learning.springMvc.dao;

import java.util.List;

import com.learning.springMvc.model.Address;

public interface AddressDao {
	
	public void save(Address address);

	public List<Address> findAllById(Long id);

}
