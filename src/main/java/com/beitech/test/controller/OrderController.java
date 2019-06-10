package com.beitech.test.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.beitech.test.model.OrderWrapper;
import com.beitech.test.service.OrderService;

/**
 * This class is a Controller to Order
 * @author Carlos
 *
 */
@RestController
public class OrderController {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	private OrderService orderService;

	@PostMapping(value="/createOrder", headers= "Accept=application/json")
	public ResponseEntity<Object> createOrder(@RequestBody OrderWrapper newOrder) {
		Map result = new HashMap();
		// Validation to size of list and quantities 
		if(newOrder.getlOrderDetails().size()<1) {
			result.put("status", "ERROR");
			result.put("message", "Debe elegir un elemento para la orden.");			
			return new ResponseEntity<Object>(result, HttpStatus.BAD_REQUEST); 
		}else if (newOrder.getlOrderDetails().size()>5) {
			result.put("status", "ERROR");
			result.put("message", "El Máximo permitido son 5 elementos para la orden.");			
			return new ResponseEntity<Object>(result, HttpStatus.BAD_REQUEST); 
		}else if(this.orderService.countQuantity(newOrder.getlOrderDetails())>5) {
				result.put("status", "ERROR");
				result.put("message", "El Máximo permitido son 5 en total de la cantidades de los elementos para la orden.");							
				return new ResponseEntity<Object>(result, HttpStatus.BAD_REQUEST); 
		}else {	
			// Save Order and details
			result = this.orderService.createOrder(newOrder.getOrder(), newOrder.getlOrderDetails());
			if( result.get("status").equals("ERROR")) {
				logger.debug("Error en la creacion del registro.");
				return new ResponseEntity<Object>(result, HttpStatus.INTERNAL_SERVER_ERROR);
			}			
			return new ResponseEntity<Object>(result, HttpStatus.CREATED); 
		}
	}

	/**
	 * This method is to consult the Order a OrderDetails of a specific Customer between a range of date.
	 * @param customerId
	 * @param startDate
	 * @param endDate
	 * @return List of Order + OrderDetails in a OrderWrapper.
	 */
	@RequestMapping(value="/listOrders", params = {"customerId","startDate", "endDate" }, method=RequestMethod.GET, headers="Accept=application/json")
	public ResponseEntity<List<OrderWrapper>> getOrdersCustomer(@RequestParam(value="customerId") Long customerId,  @RequestParam(value="startDate") @DateTimeFormat(pattern="yyyy-MM-dd")  Date startDate,@RequestParam(value="endDate") @DateTimeFormat(pattern="yyyy-MM-dd")  Date endDate){
		List<OrderWrapper> lOrderWrapper = this.orderService.consultOrdersbyCustomer(customerId, startDate, endDate);
		return new ResponseEntity<List<OrderWrapper>>(lOrderWrapper, HttpStatus.OK) ;
	}
	
}
