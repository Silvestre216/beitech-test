package com.beitech.test.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.beitech.test.model.Order;
import com.beitech.test.model.OrderDetail;
import com.beitech.test.model.OrderWrapper;

/**
 * This class is a Service to Order
 * @author Carlos
 *
 */
public interface OrderService {
	
	/**
	 * This method is to create a order with its specific details.
	 * @param order Order to save
	 * @param orderDetails details of order to save
	 * @return Map whit a structure (status: {SUCCESS or ERROR}, message :{Mensaje to error or success}, order: {if success return a order after save})
	 */
	public Map createOrder(Order order, List<OrderDetail> orderDetails);
	
	/**
	 * This method is to consult all orders to specific customer between in a date range.
	 * @param customerId Id customer
	 * @param starDate Low filter date
	 * @param endDate High filter date
	 * @return List of orders of a specific customer between in a date range. 
	 */
	public List<OrderWrapper> consultOrdersbyCustomer(Long customerId, Date starDate, Date endDate);	
	
	
	/**
	 * This method is to count the quantities of products in the list of Order detail.
	 * @param orderDetails List of details.
	 * @return Number of quantities in the list of details.
	 */
	public int countQuantity(List<OrderDetail> orderDetails);	
	
	

}
