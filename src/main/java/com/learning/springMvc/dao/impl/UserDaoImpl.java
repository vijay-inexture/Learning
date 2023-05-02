package com.learning.springMvc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.learning.springMvc.dao.UserDao;
import com.learning.springMvc.model.Address;
import com.learning.springMvc.model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public User findByEmail(String email) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<User> query = currentSession.createQuery("from user where email=:email", User.class);
		query.setParameter("email", email);
		User user = query.uniqueResult();
        return user;
	}
	
	@Override
	public User findById(Long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		User user = currentSession.get(User.class, id);
        return user;
	}

	@Override
	public List<User> findAll() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<User> query = currentSession.createQuery("from user", User.class);
		List<User> users = query.getResultList();
		return users;
	}

	
	@Override
	public void save(User user) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.persist(user);
	}
	
	@Override
	public void update(User user) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.merge(user);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void deleteById(Long userId) {
		Session currentSession = sessionFactory.getCurrentSession();
		User user = findById(userId);
		if(user!=null) {
			currentSession.delete(user);
		}
	}

	@Override
	public void updatePassword(String email, String newPassword) {
		Session currentSession = sessionFactory.getCurrentSession();
		User user = findByEmail(email);
		user.setPassword(newPassword);
		currentSession.merge(user);
	}


}
