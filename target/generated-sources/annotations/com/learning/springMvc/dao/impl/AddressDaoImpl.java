package com.learning.springMvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.learning.springMvc.dao.AddressDao;
import com.learning.springMvc.model.Address;
import com.learning.springMvc.model.User;

@Repository
public class AddressDaoImpl implements AddressDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void save(Address address) {
		String sql = "INSERT INTO address(street, city, user_id) VALUES(?,?,?)" ;
		jdbcTemplate.update(sql, address.getStreet(),address.getCity(),address.getUserId());
	}

	@Override
	public List<Address> findAllById(Long user_id) {
		String sql = "SELECT * FROM address where user_id = ?";
		List<Address> addresses = jdbcTemplate.query(sql, new Object[] {user_id}, rs -> {
			List<Address> addressList = new ArrayList<>();
           while (rs.next()) {
        	   Address address = new Address();
        	   address.setStreet(rs.getString("street"));
        	   address.setCity(rs.getString("city"));
        	   addressList.add(address);
           }
           return addressList;
       });
		return addresses;
	}

}
