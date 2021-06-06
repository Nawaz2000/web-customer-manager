package com.nawaz2000.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.nawaz2000.spring.entity.Customer;

@Repository("customerDAOimpl")
public class CustomerDAOimpl {
	
	@Autowired
	@Qualifier("sessionFactory")
	SessionFactory sessionFactory;
	
	public void addCustomer(Customer customer) {	
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(customer);
		
	}

	public List<Customer> listCustomers() {
		Session session = sessionFactory.getCurrentSession();
		List<Customer>customerList = session.createQuery("from Customer", 
				Customer.class).getResultList();
		return customerList;
	}

	public Customer getCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Customer.class, id);
	}
	
}
