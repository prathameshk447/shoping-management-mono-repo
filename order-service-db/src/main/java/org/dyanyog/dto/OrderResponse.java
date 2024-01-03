package org.dyanyog.dto;


import org.springframework.stereotype.Component;

@Component
public class OrderResponse {

	private String status;
	private String message;
	private long order_id;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}

	public void setOrdername(String ordername) {
		
		
	}

	public void setQuantity(String quantity) {
		
		
	}

	public void setType(String type) {
		
	}

	public void setPrice(String price) {
		
		
	}

	
}