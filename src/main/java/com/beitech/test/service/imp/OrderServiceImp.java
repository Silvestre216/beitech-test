package com.beitech.test.service.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beitech.test.model.CustomerProduct;
import com.beitech.test.model.CustomerProductId;
import com.beitech.test.model.Order;
import com.beitech.test.model.OrderDetail;
import com.beitech.test.model.OrderWrapper;
import com.beitech.test.model.Product;
import com.beitech.test.repository.OrderRepository;
import com.beitech.test.service.CustomerProductService;
import com.beitech.test.service.OrderDetailService;
import com.beitech.test.service.OrderService;
import com.beitech.test.service.ProductService;

@Service
public class OrderServiceImp implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderDetailService orderDetailService;	
	
	@Autowired
	private CustomerProductService customerProductService;
	
	@Autowired
	private ProductService productService;

	@Override
	@Transactional
	public Map createOrder(Order order, List<OrderDetail> lOrderDetails) {
		Map result = new HashMap();		
		boolean status = false;
		Product po;
		float totalOrder =0;
		for(OrderDetail detail: lOrderDetails) {
			// Validate allows products
			CustomerProductId cpId = new CustomerProductId(order.getCustomer(), detail.getProductId());
			status = this.customerProductService.isAllowProduct(cpId);			
			if(!status) {
				result.put("status", "ERROR");
				result.put("message", "Existe productos no permitidos para el customer.");				
				return result; // Products don't allows
			}
			
			// Consult product details
			po = new Product();
			po = this.productService.consultProduct(detail.getProductId().getProductId());
			detail.setProductDescription(po.getProductDescription());
			detail.setPrice(po.getPrice());	
			
			totalOrder += (detail.getPrice())*(detail.getQuantity());
						
		}
		order.setTotal(totalOrder);
		order.setCreationDate(new Date());
		//Save order with out total
		order = this.orderRepository.save(order);
		// Save Details
		if(this.orderDetailService.addOrderDetail(lOrderDetails, order)==0){
			//Save order with  total
			
			result.put("status", "SUCCESS");
			result.put("message", "Registro Creado Exitosamente.");
			result.put("order", order);
			return result;
		}else {			
			result.put("status", "ERROR");
			result.put("message", "No se ha creado el registro, error en el guardado.");		
			return result;
		}
		
	}
	
	@Override
	public List<OrderWrapper> consultOrdersbyCustomer(Long customerId, Date starDate, Date endDate) {
		List<OrderWrapper> result = new ArrayList<>();
		OrderWrapper orderW;
		List<Order> lOrders = this.orderRepository.findOrdersFromCustomer(customerId, starDate, endDate);
		for(Order or: lOrders) {
			System.out.println(or.getOrderId() +" - "+ or.getCreationDate());
			orderW = new OrderWrapper();
			orderW.setOrder(or);
			orderW.setlOrderDetails(this.orderDetailService.getOrderDetailByOrder(or.getOrderId()));
			System.out.println(orderW.getOrder().getOrderId() +" ++ "+ orderW.getOrder().getCreationDate());
			result.add(orderW);
		}
		
		return result;
	}
	
	@Override
	public int countQuantity(List<OrderDetail> lorderDetails) {
		int count=0;
		for(OrderDetail detail: lorderDetails) {
			count += detail.getQuantity();
		}
		return count;
	}

}
