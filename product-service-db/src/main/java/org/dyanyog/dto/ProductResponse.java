package org.dyanyog.dto;


import org.springframework.stereotype.Component;

@Component
public class ProductResponse {

	private String status;
	private String message;
	private long product_id;

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

	public long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}

	public void setProductname(String productname) {
		// TODO Auto-generated method stub
		
	}

	public void setQuantity(String quantity) {
		// TODO Auto-generated method stub
		
	}

	public void setType(String type) {
		// TODO Auto-generated method stub
		
	}

	public void setPrice(String price) {
		// TODO Auto-generated method stub
		
	}

	
}