package com.spoms.order.reprint.serviceIMPL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spoms.order.reprint.model.OrderDetailsBO;
import com.spoms.order.reprint.repository.OrderDetailsRepository;
import com.spoms.order.reprint.service.OrderDetailsService;

@Component
public class OrderDetailsServiceIMPL implements OrderDetailsService{

	@Autowired
	OrderDetailsRepository repo;
	
	@Override
	public OrderDetailsBO getOrderDetailsService(String shipment_num) {
		
		// Business Logic
		
		
		
		return null;
	}

}
