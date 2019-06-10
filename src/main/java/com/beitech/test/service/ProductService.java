package com.beitech.test.service;

import java.util.Optional;

import com.beitech.test.model.Product;

/**
 * This class is a Service to Product
 * @author Carlos
 *
 */
public interface ProductService {	
	
	/**
	 * This method get a product by a specific productId
	 * @param productId Id product
	 * @return A product
	 */
	public Product consultProduct(Long productId);

}
