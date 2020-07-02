package com.ness.microservice.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ness.microservice.order.domain.OrderItem;


@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

	@Query("SELECT o FROM OrderItem o WHERE o.orderId = :orderId")
	public List<OrderItem> find(@Param("orderId") int orderId);
	
	@Query("SELECT o FROM OrderItem o WHERE o.orderId = :orderId and o.productId=:productId")
	public List<OrderItem> find(@Param("orderId") int orderId,@Param("productId") int productId);

}
