package com.ness.microservice.order.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ness.microservice.order.domain.OrderItem;
import com.ness.microservice.order.exception.OrderItemNotFoundException;
import com.ness.microservice.order.repository.OrderItemRepository;


@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemRepository orderItemRepository;
	@Override
	public OrderItem createOrder(OrderItem orderItem) {
		OrderItem Item = orderItemRepository.save(orderItem);
		return Item;
	}

	@Override
	public List<OrderItem> getAllOrderItem(int orderId) {
		// TODO Auto-generated method stub
		List<OrderItem> orderItems = orderItemRepository.find(orderId);
		return orderItems;
	}

	@Override
	public List<OrderItem> getOrderItem(int oid,int pid) {
		List<OrderItem> orderItem =  orderItemRepository.find(oid, pid);
		if (orderItem.iterator().hasNext()) {
			return orderItem;
		}else {
			throw new OrderItemNotFoundException(" OrderId: " +oid +" & productId:"+pid);
		}
		
	}

}
