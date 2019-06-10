package com.beitech.test.service.imp;

import java.util.List;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.beitech.test.model.Order;
import com.beitech.test.model.OrderDetail;
import com.beitech.test.model.Product;
import com.beitech.test.repository.OrderDetailRepository;
import com.beitech.test.service.OrderDetailService;
import com.beitech.test.service.ProductService;

@Service
public class OrderDetailServiceImp implements OrderDetailService {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderDetailServiceImp.class);
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;

	@Override
	@Transactional
	public int addOrderDetail(List<OrderDetail> lOrderDetails, Order order) {		
		try {
			
			for (OrderDetail detail : lOrderDetails) {				
				detail.setOrder(order);						
				this.orderDetailRepository.save(detail);
				
			}
			return 0;
		} catch (Exception e) {
			logger.debug("Eror guardando los detalles de la orden."+e.getMessage());;
			return 1;

		}
	}


	@Override
	public List<OrderDetail> getOrderDetailByOrder(Long orderId) {
		return this.orderDetailRepository.findByOrderOrderId(orderId);
		
	}	
	
}
