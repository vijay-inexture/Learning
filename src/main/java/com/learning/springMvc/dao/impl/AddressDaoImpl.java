package com.learning.springMvc.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.learning.springMvc.dao.AddressDao;
import com.learning.springMvc.model.Address;

@Repository
@Transactional
public class AddressDaoImpl implements AddressDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Address address) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.persist(address);
	}
	
	@Override
	public List<Address> findAllByUserId(Long userId) {
	    Session currentSession = sessionFactory.getCurrentSession();
	    String hql = "FROM address WHERE user.id = :userId";
	    Query<Address> query = currentSession.createQuery(hql, Address.class);
	    query.setParameter("userId", userId);
	    List<Address> addresses = query.getResultList();
	    return addresses;
	}
	
	@Override
	public Address findById(Long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Address address = currentSession.get(Address.class, id);
		return address;
	}

	@Override
	public void updateAddress(Address address) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.merge(address);		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void deleteById(Long addressId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Address address = findById(addressId);
		if(address!=null) {
			currentSession.delete(address);	
		}
	}

}
