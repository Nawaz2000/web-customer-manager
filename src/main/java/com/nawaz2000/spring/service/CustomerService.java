package com.nawaz2000.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nawaz2000.spring.dao.CustomerDAOimpl;
import com.nawaz2000.spring.entity.Customer;

@Service("customerService")
public class CustomerService {
	
	@Autowired
	@Qualifier("customerDAOimpl")
	CustomerDAOimpl customerDAO;
	
	@Transactional
	public void addCustomer(Customer customer) {
		customerDAO.addCustomer(customer);
	}
	
	@Transactional
	public List<Customer> getAllCustomers(){
		return customerDAO.listCustomers();
	}

	@Transactional
	public Customer getCustomer(int id) {
		return customerDAO.getCustomer(id);
	}

	@Transactional
	public void deleteCustomer(int id) {
		customerDAO.deleteCustomer(id);
		
	}

	@Transactional
	public List<Customer> searchCustomers(String searchName) {
		List<Customer> searchResult = customerDAO.searchCustomers(searchName);
		return searchResult;
	}

	@Transactional
	public List<Customer> getCustomers(int sortField) {
		return customerDAO.getCustomers(sortField);
	}
	
	
}
