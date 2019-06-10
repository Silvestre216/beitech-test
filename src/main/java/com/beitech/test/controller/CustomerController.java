package com.beitech.test.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.beitech.test.model.Customer;
import com.beitech.test.service.CustomerService;

/**
 * This class is a Controller to Customer
 * @author Carlos
 *
 */
@RestController
public class CustomerController {
	
	

	@Autowired
	CustomerService customerService;
	
	/**
	 * This method is to consult all Customers in a database
	 * @return List of customers.
	 */
	@RequestMapping(value="/getAllCustomers", method=RequestMethod.GET, headers= "Accept=application/json")
	public List<Customer> consultAllCustomers(){
		return customerService.consultAllCustomers();
	}	
	

}

