package com.beitech.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beitech.test.model.Product;
/**
 * This class is a Database Repository of ProductRepository
 * @author Carlos
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	/**
	 * This function is to find a Product by a specific Id
	 * @param productId PK of product
	 * @return A Product
	 */
	public Product findByProductId(Long productId);

}
