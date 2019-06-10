package com.beitech.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beitech.test.model.OrderDetail;
/**
 * This class is a Database Repository of Order Detail
 * @author Carlos
 *
 */
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
	
	/**
	 * This function is to find the list of order details by OrderId
	 * @param orderId Id to order
	 * @return List of orderDetail.
	 */
	public List<OrderDetail> findByOrderOrderId(Long orderId);

}
