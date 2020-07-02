package com.ness.microservice.order.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ness.microservice.order.domain.OrderItem;
import com.ness.microservice.order.service.OrderItemServiceImpl;

@RestController
public class OrderItemController {

	@Autowired
	private OrderItemServiceImpl orderItemServiceImpl;
	
	@GetMapping("/orders/{oid}/items")
	public List<OrderItem> listAllOrderItems(@PathVariable int oid){
		return orderItemServiceImpl.getAllOrderItem(oid);
	}
	
	@GetMapping("/orders/{oid}/items/{pid}")
	public List<OrderItem> getOrderItem(@PathVariable int oid,@PathVariable int pid){
		return orderItemServiceImpl.getOrderItem(oid,pid);
	}
	
	@PostMapping("/orders/{oid}/items")
	public ResponseEntity<OrderItem> createOrder(@PathVariable int oid ,@RequestBody OrderItem orderItem) {
		OrderItem item = orderItem;
		item.setOrderId(oid); 
		OrderItem Item = orderItemServiceImpl.createOrder(item);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(Item.getProductId())
				.toUri();
		return ResponseEntity.created(uri).build();		
		
	}
}
