package org.dyanyog.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Component
@Table
public class Orders {

	@GeneratedValue
	@Id
	@Column
	private long order_id;
	
	public long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}
	@Column
    private String status;
	@Column
    private String message;
	@Column
	private String ordername;
	
	@Column
	private String quantity;
	
	@Column
	private String type;
	
	@Column
	private String price;

	public String getOrdername() {
		return ordername;
	}

	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus( String status) {
		this.status= status;
		
	}
	public String getMessage() {
		return message;
	}

	public void setMessage( String message) {
		this.message= message;
		
	}
}
