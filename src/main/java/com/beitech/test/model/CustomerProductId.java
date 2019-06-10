package com.beitech.test.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * This class is the primary key of CustomerProduct entity 
 * @author Carlos
 *
 */
@Embeddable
public class CustomerProductId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
		
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	protected CustomerProductId(){}
	
	public CustomerProductId(Customer customer, Product product) {
		super();
		this.customer = customer;
		this.product = product;
	}

	
	
	

}
