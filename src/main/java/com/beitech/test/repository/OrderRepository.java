package com.beitech.test.repository;

import java.util.Date;
import java.util.List;


import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.beitech.test.model.Order;
/**
 * This class is a Database Repository of Order
 * @author Carlos
 *
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	/**
	 * This function find all orders between a date range and with specific customer.
	 * @param CustomerId Id of customer
	 * @param startDate Low Date to filter
	 * @param endDate High Date to filter
	 * @return A List of Order in this specific dates and customer.
	 */
	@Query(value="SELECT * FROM test.order o WHERE o.customer_id = :customer AND o.creation_date BETWEEN :startDate AND :endDate",
			nativeQuery = true)
	public List<Order> findOrdersFromCustomer(@Param("customer")Long CustomerId, @Param("startDate") @Temporal(TemporalType.DATE) Date startDate, @Param("endDate") @Temporal(TemporalType.DATE) Date endDate);

}
