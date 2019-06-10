package com.beitech.test.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.beitech.test.model.Product;
import com.beitech.test.repository.ProductRepository;
import com.beitech.test.service.ProductService;

@Service
public class ProductServiceImp implements ProductService {
	
	@Autowired 
	private ProductRepository productRepository;

	@Override
	public Product consultProduct(Long productId) {
		return this.productRepository.findByProductId(productId);
	}
	
	
}
