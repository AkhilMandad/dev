package com.spoms.order.reprint.service;

import org.springframework.stereotype.Service;

import com.spoms.order.reprint.model.OrderDetailsBO;

@Service
public interface OrderDetailsService {

	OrderDetailsBO getOrderDetailsService(String shipment_num);

}
