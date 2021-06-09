package com.nawaz2000.spring.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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

	public void deleteCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Customer retrievedCustomer = session.get(Customer.class, id);
		session.delete(retrievedCustomer);
		
	}

	public List<Customer> searchCustomers(String searchName) {
		Session session = sessionFactory.getCurrentSession();
		if (searchName != null && searchName.trim().length()>0) {
			String[] name = searchName.split("\\s+");
			String fName = name[0];
			String lName = name[1];
			Query query = session.createQuery("from Customer where firstName = " + "'" + fName + "'" + " AND lastName = " + "'" + lName + "'", Customer.class);
			System.out.println("My query: " + query);
			return query.getResultList();
		}else {
			List<Customer> searchResult = new ArrayList<Customer>();
			return searchResult;
		}
	}
	
}
