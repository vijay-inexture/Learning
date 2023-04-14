package com.learning.springMvc.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.learning.springMvc.dao.UserDao;
import com.learning.springMvc.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public User findByEmail(String email) {
		System.out.println(email);
		Long id = 1L;
		String sql = "SELECT id, name, email, role FROM user WHERE email = ?";
        User user = jdbcTemplate.query(sql, new Object[]{email}, 
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
        });
        return user;
	}

	@Override
	public List<User> findAll() {
		String sql = "SELECT id, name, email, role FROM user";
//		 List<User> users = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(User.class));
		List<User> users = jdbcTemplate.query(sql, rs -> {
            List<User> userList = new ArrayList<>();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setRole(rs.getString("role"));
                userList.add(user);
            }
            return userList;
        });
		return users;
	}

	@Override
	public void save(User user) {
		String sql = "INSERT INTO user(name, email, role) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getRole());
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
