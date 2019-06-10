package com.beitech.test.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beitech.test.model.CustomerProduct;
import com.beitech.test.model.CustomerProductId;
import com.beitech.test.repository.CustomerProductRepository;
import com.beitech.test.service.CustomerProductService;

@Service
public class CustomerProductServiceImp implements CustomerProductService {
	@Autowired
	private CustomerProductRepository customerProductRepository;
	
	@Override
	public List<CustomerProduct> getProductsAllowCustomer(Long customerId) {
		return this.customerProductRepository.findByCustomerProductIdCustomer(customerId);		
	}

	@Override
	public boolean isAllowProduct(CustomerProductId customerProductId) {
		CustomerProduct cp ;
		cp = this.customerProductRepository.findByCustomerProductId(customerProductId);
		//System.out.println(cp);		
		return (cp != null ? true:false);
	}

}
