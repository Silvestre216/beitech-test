package com.beitech.test.service;

import java.util.List;

import com.beitech.test.model.CustomerProduct;
import com.beitech.test.model.CustomerProductId;
/**
 * This class is a Service to CustomerProduct
 * @author Carlos
 *
 */
public interface CustomerProductService {
	
	/**
	 * This method get all products allows to specific customer.
	 * @param customerId Id Customer
	 * @return List of CustomerProducts than allow a specific customer.
	 */
	public List<CustomerProduct> getProductsAllowCustomer(Long customerId);
	
	/**
	 * This method validate if a specific product is allow to a Customer.
	 * @param customerProductId Pk composite PK (customerId + productId)
	 * @return true => if allow, false => don't allow
	 */
	public boolean isAllowProduct(CustomerProductId customerProductId);

}
