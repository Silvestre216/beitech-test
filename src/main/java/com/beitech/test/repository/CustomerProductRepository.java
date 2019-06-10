package com.beitech.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beitech.test.model.Customer;
import com.beitech.test.model.CustomerProduct;
import com.beitech.test.model.CustomerProductId;
/**
 * This class is a Database Repository of CustomerProduct
 * @author Carlos
 *
 */
@Repository
public interface CustomerProductRepository extends JpaRepository<CustomerProduct, CustomerProductId> {
	
	/**
	 * This function is to finds the list of the customer product by customerid
	 * @param customerId Id of Customer
	 * @return List of customerproducts
	 */
	public List<CustomerProduct> findByCustomerProductIdCustomer(Long customerId);
	
	/**
	 * This function is to finds one element of the customer product by PK customerProductId
	 * @param customerProductId Is a PK customerProductId
	 * @return A CustomerProduct
	 */
	public CustomerProduct findByCustomerProductId(CustomerProductId customerProductId);

}
