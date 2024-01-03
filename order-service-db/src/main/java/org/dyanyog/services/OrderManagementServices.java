package org.dyanyog.services;


import java.util.Optional;


import org.dyanyog.dto.Order;
import org.dyanyog.dto.OrderRequest;
import org.dyanyog.dto.OrderResponse;
import org.dyanyog.entity.Orders;
import org.dyanyog.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class OrderManagementServices{

	@Autowired
     OrderRepository orderRepo;
	
	
	
	
	
	public OrderResponse addOrder(OrderRequest orderRequest)
	{
		OrderResponse responce = new OrderResponse();
		
		Orders o = new Orders();
		
		o.setOrdername(orderRequest.getOrdername());
		o.setQuantity(orderRequest.getQuantity());
		o.setType(orderRequest.getType());
		o.setPrice(orderRequest.getPrice());
		
		o =orderRepo.save(o);
		
		responce.setStatus("Success");
		responce.setMessage("order added successfully");
		responce.setOrder_id(o.getOrder_id());
		
		return responce;
	}


    
	public Order getSingleOrder(long orderId) {
    	
    	Order orderResponse = new Order();
    	
    	java.util.Optional<Orders> receiveData = orderRepo.findById(orderId);
    	
    
		if( receiveData.isEmpty()) {
    		orderResponse.setStatus("Fail");
    		orderResponse.setMessage("order not found");
    	}else
    	{
    		Orders order = (Orders) receiveData.get();
    		orderResponse.setStatus("success");
    		orderResponse.setMessage("order found");
    
    		orderResponse.setOrdername(order.getOrdername());
    		orderResponse.setQuantity(order.getQuantity());
    		orderResponse.setType(order.getType());
    		orderResponse.setPrice(order.getPrice());
    		
    		orderResponse.setOrder_id(order.getOrder_id());
    		
    	}
    	return orderResponse;
    	
    }
	public String deleteorder(Long orderId) {
		orderRepo.deleteById(orderId);
			return "The Order Id" +orderId +"has been cancelled";
		}

		public OrderResponse UpdateOrder(Long orderId, OrderRequest request) {
			
			OrderResponse response = new OrderResponse();
			Optional<Orders> receivedData = orderRepo.findById(orderId);
			if(receivedData.isPresent()) {
				
			Orders ordersTable = new Orders();
			
			ordersTable.setOrdername(request.getOrdername());
			ordersTable.setType(request.getType());
			ordersTable.setQuantity(request.getQuantity());
			ordersTable.setPrice(request.getPrice());
			ordersTable.setOrder_id(orderId);
		    ordersTable = orderRepo.save(ordersTable);
		    
		    response.setMessage("Order information updated Successfully");
		    response.setStatus("Success");
		    response.setOrder_id(orderId);
		    response.setOrdername(ordersTable.getOrdername());
		    response.setQuantity(ordersTable.getQuantity());
		    response.setType(ordersTable.getType());
		    response.setPrice(ordersTable.getPrice());
		    
		
		}
			return response;
		}



		
	}


	


