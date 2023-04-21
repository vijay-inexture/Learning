package com.learning.springMvc.dao.impl;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.learning.springMvc.dao.UserDao;
import com.learning.springMvc.model.Address;
import com.learning.springMvc.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public User findByEmail(String email) {
		String sql = "SELECT * FROM user WHERE email = ?";
		User user = jdbcTemplate.query(sql,  
	        	rs -> {
	            if (rs.next()) {
	                User userData = new User();
	                userData.setId(rs.getLong("id"));
	                userData.setName(rs.getString("name"));
	                userData.setEmail(rs.getString("email"));
	                userData.setPassword(rs.getString("password"));
	                userData.setRole(rs.getString("role"));
	                return userData;
	            } else {
	                return null;
	            }
	        }, email);
        return user;
	}
	
	@Override
	public User findById(Long id) {
		String sql = "SELECT * FROM user WHERE id = ?";
        User user = jdbcTemplate.query(sql,  
        	rs -> {
            if (rs.next()) {
                User userData = new User();
                userData.setId(rs.getLong("id"));
                userData.setName(rs.getString("name"));
                userData.setEmail(rs.getString("email"));
                userData.setRole(rs.getString("role"));
                return userData;
            } else {
                return null;
            }
        }, id);
        return user;
	}

	@Override
	public List<User> findAll() {
		String sql = "SELECT * FROM user";
		List<User> users = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(User.class));
		return users;
	}

	@Override
	public void save(User user) {
		System.out.println("userDao");
		String sql = "INSERT INTO user(name, email, password, role) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(),user.getPassword(), user.getRole());
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}


}
