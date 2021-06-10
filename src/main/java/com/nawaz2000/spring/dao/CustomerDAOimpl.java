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
		String queryString = null;
		Query<Customer> theQuery = null;
		List<Customer> customers = null;

		
		
		switch (sortField) {
		case 1:
			theFieldName = "firstName";
			// create a query
			queryString = "from Customer order by " + theFieldName;
			theQuery = session.createQuery(queryString, Customer.class);

			// execute query and get result list
			customers = theQuery.getResultList();
			SortUtils.updateFirstName();
			
			if (SortUtils.LAST_NAME == 20)
				SortUtils.LAST_NAME = 2;
			if (SortUtils.EMAIL == 30)
				SortUtils.EMAIL = 3;
			
			break;
		case 2:
			theFieldName = "lastName";
			// create a query
			queryString = "from Customer order by " + theFieldName;
			theQuery = session.createQuery(queryString, Customer.class);

			// execute query and get result list
			customers = theQuery.getResultList();
			SortUtils.updateLastName();
			
			if (SortUtils.FIRST_NAME == 10)
				SortUtils.FIRST_NAME = 1;
			if (SortUtils.EMAIL == 30)
				SortUtils.EMAIL = 3;
			
			break;
		case 3:
			theFieldName = "email";
			// create a query
			queryString = "from Customer order by " + theFieldName;
			theQuery = session.createQuery(queryString, Customer.class);

			// execute query and get result list
			customers = theQuery.getResultList();
			SortUtils.updateEmail();
			
			if (SortUtils.FIRST_NAME == 10)
				SortUtils.FIRST_NAME = 1;
			if (SortUtils.LAST_NAME == 20)
				SortUtils.LAST_NAME = 2;
			
			break;
		case 10:
			queryString = "from Customer";
			theQuery = session.createQuery(queryString, Customer.class);

			// execute query and get result list
			customers = theQuery.getResultList();
			SortUtils.updateFirstName();
			break;
		case 20:
			queryString = "from Customer";
			theQuery = session.createQuery(queryString, Customer.class);

			// execute query and get result list
			customers = theQuery.getResultList();
			SortUtils.updateLastName();
			break;
		case 30:
			queryString = "from Customer";
			theQuery = session.createQuery(queryString, Customer.class);

			// execute query and get result list
			customers = theQuery.getResultList();
			SortUtils.updateEmail();
		}

		// return the results
		return customers;
	}

}
