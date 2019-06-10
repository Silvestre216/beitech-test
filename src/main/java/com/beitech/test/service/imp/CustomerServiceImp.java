package com.beitech.test.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beitech.test.model.Customer;
import com.beitech.test.repository.CustomerRepository;
import com.beitech.test.service.CustomerService;
@Service
public class CustomerServiceImp implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	public CustomerServiceImp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Customer> consultAllCustomers() {		
		return (List<Customer>) customerRepository.findAll();
	}

}

