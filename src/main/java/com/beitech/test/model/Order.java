package com.beitech.test.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * This class is a Entity of Order
 * @author Carlos
 *
 */
@Entity
@Table(name="[order]")
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "order_id", nullable = false, precision = 10)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
		
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;

	
	@Column(name = "creation_date", columnDefinition="DATE")
	@Temporal(TemporalType.DATE)
	private Date creationDate;

	@Column(name = "delivery_address", nullable = false, length = 191)
	private String deliveryAddress;

	@Column(name = "total", precision = 15, scale = 2)
	private float total;
	
	protected Order(){}
	
	public Order(Long orderId, Customer customer, Date creationDate, String deliveryAddress, float total) {
		super();
		this.orderId = orderId;
		this.customer = customer;
		this.creationDate = creationDate;
		this.deliveryAddress = deliveryAddress;
		this.total = total;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public float getTotal() {
		return total;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setTotal(float total) {
		this.total = total;
	}

}
