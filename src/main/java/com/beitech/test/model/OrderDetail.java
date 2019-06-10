package com.beitech.test.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * This class is a Entity of OrderDetail
 * @author Carlos
 *
 */
@Entity
public class OrderDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="order_detail_id", nullable=false, precision=10)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderDetailId;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;
	
	@ManyToOne		
	@JoinColumn(name="product_id")
	private Product product;
	
	@Column(name = "product_description", nullable = false, length = 191)
	private String productDescription;
	
	@Column(name="price", precision=10, scale=2)
	private float price;
	
	@Column(name="quantity", precision=10)
	private int quantity;
	
	protected OrderDetail(){}
	
	public OrderDetail(Long orderDetailId, Order order, Product product, String productDescription, float price,
			int quantity) {
		super();
		this.orderDetailId = orderDetailId;
		this.order = order;
		this.product = product;
		this.productDescription = productDescription;
		this.price = price;
		this.quantity = quantity;
	}
	

	public Long getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(Long orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProductId() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	

}
