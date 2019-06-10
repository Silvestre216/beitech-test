package com.beitech.test.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * This class is a Entity of Customer_Product
 * @author Carlos
 *
 */
@Entity
@Table(name="customer_product")
public class CustomerProduct implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private CustomerProductId customerProductId;

	protected CustomerProduct(){}
	
	public CustomerProduct(CustomerProductId customerProductId) {
		super();
		this.customerProductId = customerProductId;
	}
	
	

}
