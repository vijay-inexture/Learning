package com.learning.springMvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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
	public List<Address> findAllByUserId(Long userId) {
	    String sql = "SELECT * FROM address where user_id = ?";
	    List<Address> addresses = jdbcTemplate.query(sql, 
	            BeanPropertyRowMapper.newInstance(Address.class), userId);
	    return addresses;
	}
	
	@Override
	public Address findById(Long id) {
		String sql = "SELECT * FROM address where id=?";
		Address address = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Address.class), id);
		return address;
	}

	@Override
	public void updateAddress(Address address) {
		String sql = "UPDATE address SET street=?, city=? WHERE id=?";
		jdbcTemplate.update(sql, address.getStreet(), address.getCity(), address.getId());		
	}

	@Override
	public void deleteById(Long addressId) {
		String sql = "DELETE FROM address WHERE id=?";
		jdbcTemplate.update(sql, addressId);		
	}

	@Override
	public void deleteAllByUserId(Long userId) {
		String sql = "DELETE FROM address WHERE user_id=?";
		jdbcTemplate.update(sql, userId);
	}

}
