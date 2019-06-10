package com.beitech.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.beitech.test.model.Customer;

/**
 * This class is a Database Repository of Customer
 * @author Carlos
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
