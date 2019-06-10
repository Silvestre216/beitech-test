package com.beitech.test.service;

import java.util.List;

import com.beitech.test.model.Customer;

/**
 * This class is a Service to Customer
 * @author Carlos
 *
 */
public interface CustomerService {

	/**
	 * This method get all customers in entity Customer
	 * @return List of customers
	 */
	public List<Customer> consultAllCustomers();

}
