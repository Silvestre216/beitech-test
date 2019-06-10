package com.beitech.test.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This class is a Entity of Product
 * @author Carlos
 *
 */
@Entity
public class Product implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="product_id", nullable = false, precision=10)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long productId;
	
	@Column(name = "name", nullable = false, length = 191)
	private String name;
	
	@Column(name = "product_description", nullable = false, length = 191)
	private String productDescription;
	
	@Column(name="price", precision=10, scale=2)
	private float price;

	public Product(){}
	
	public Product(Long productId, String name, String productDescription, float price) {
		super();
		this.productId = productId;
		this.name = name;
		this.productDescription = productDescription;
		this.price = price;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
	

}
