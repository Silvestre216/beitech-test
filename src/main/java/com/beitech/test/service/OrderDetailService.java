package com.beitech.test.service;

import java.util.List;

import com.beitech.test.model.Order;
import com.beitech.test.model.OrderDetail;

/**
 * This class is a Service to OrderDetail
 * @author Carlos
 *
 */
public interface OrderDetailService {
	
	/**
	 * This method is to create all order details to a specific order. 
	 * @param lOrderDetails List of details to a specific order.
	 * @param order Order to assigned the list of details
	 * @return
	 */
	public int addOrderDetail(List<OrderDetail> lOrderDetails, Order order);
	
	/**
	 * This method find all order details of the a specific order
	 * @param orderId orderId
	 * @return List of order detail asociated a specific order 
	 */
	public List<OrderDetail> getOrderDetailByOrder(Long orderId);

}
