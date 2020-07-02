package com.ness.microservice.order.service;

import java.util.List;
import java.util.Optional;

import com.ness.microservice.order.domain.OrderItem;

public interface OrderItemService {
	public OrderItem createOrder(OrderItem orderItem);
	public List<OrderItem> getAllOrderItem(int orderId);
	public List<OrderItem> getOrderItem(int Orderid,int porductId);
}
