package com.beitech.test.model;

import java.util.List;

/**
 * This class is use to create a body request to Order + details.
 * @author Carlos
 *
 */
public class OrderWrapper {
	
	private Order order;
	
	private List<OrderDetail> lOrderDetails;

	public OrderWrapper(Order order, List<OrderDetail> lOrderDetails) {
		super();
		this.order = order;
		this.lOrderDetails = lOrderDetails;
	}

	public OrderWrapper() {
	
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<OrderDetail> getlOrderDetails() {
		return lOrderDetails;
	}

	public void setlOrderDetails(List<OrderDetail> lOrderDetails) {
		this.lOrderDetails = lOrderDetails;
	}
	
	

}
