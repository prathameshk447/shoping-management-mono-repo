package org.dyanyog.controller;



import org.dyanyog.services.OrderManagementServices;
import org.dyanyog.dto.Order;
import org.dyanyog.dto.OrderRequest;

import org.dyanyog.dto.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderManagementController {

	@Autowired
	OrderManagementServices orderservice;
	
	@PostMapping(path= "/auth/order", consumes = {"application/json" , "application/xml"}, 
			produces = {"application/json" , "application/xml"})
	public OrderResponse addUpdateOrder(@RequestBody OrderRequest request)
	{
		return orderservice.addOrder(request);
	}
	@GetMapping(path="/auth/order/{orderId}")
	public Order getSingleOrder(@PathVariable long orderId)
	{
		return orderservice.getSingleOrder(orderId);
		
	}
	
	@DeleteMapping(path="/auth/order/delete/{orderId}")
	public String deleteorder(@PathVariable Long orderId)
	{
		return orderservice.deleteorder(orderId);
		
	}
	
	@PostMapping(path="/auth/order/update/{orderId}",
			 consumes = {"application/json","application/xml"},
		      produces = {"application/json","application/xml"})
	public OrderResponse UpdateOrder(@RequestBody OrderRequest orderRequest,@PathVariable Long orderId)
	{
		return orderservice.UpdateOrder(orderId, orderRequest);
	}
	
	
	
}