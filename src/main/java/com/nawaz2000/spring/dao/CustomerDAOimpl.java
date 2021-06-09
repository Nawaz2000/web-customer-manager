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
import com.nawaz2000.spring.util.SortUtils;

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
		List<Customer> customerList = session.createQuery("from Customer", Customer.class).getResultList();
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
		if (searchName != null && searchName.trim().length() > 0) {
			Query query = session
					.createQuery(
							"from Customer where lower(firstName) LIKE " + "'%" + searchName.toLowerCase() + "%'"
									+ " OR lower(lastName) LIKE " + "'%" + searchName.toLowerCase() + "%'",
							Customer.class);
			System.out.println("My query: " + query);
			return query.getResultList();

		} else {
			List<Customer> searchResult = new ArrayList<Customer>();
			return searchResult;
		}
	}

	public List<Customer> getCustomers(int sortField) {
		Session session = sessionFactory.getCurrentSession();

		String theFieldName = null;

		switch (sortField) {
		case SortUtils.FIRST_NAME:
			theFieldName = "firstName";
			break;
		case SortUtils.LAST_NAME:
			theFieldName = "lastName";
			break;
		case SortUtils.EMAIL:
			theFieldName = "email";
			break;
		default:
			// if nothing matches the default to sort by lastName
			theFieldName = "lastName";
		}

		// create a query
		String queryString = "from Customer order by " + theFieldName;
		Query<Customer> theQuery = session.createQuery(queryString, Customer.class);

		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();

		// return the results
		return customers;
	}

}
