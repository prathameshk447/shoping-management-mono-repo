package org.dyanyog.controller;



import org.dyanyog.services.ProductManagementServices;
import org.dyanyog.dto.Product;
import org.dyanyog.dto.ProductRequest;

import org.dyanyog.dto.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductManagementController {

	@Autowired
	ProductManagementServices productservice;
	
	@PostMapping(path= "/auth/product", consumes = {"application/json" , "application/xml"}, 
			produces = {"application/json" , "application/xml"})
	public ProductResponse addUpdateProduct(@RequestBody ProductRequest request)
	{
		return productservice.addProduct(request);
	}
	@GetMapping(path="/auth/product/{productId}")
	public Product getSingleProduct(@PathVariable long productId)
	{
		return productservice.getSingleProduct(productId);
		
	}
	
	@DeleteMapping(path="/auth/product/delete/{productId}")
	public String deleteproduct(@PathVariable Long productId)
	{
		return productservice.deleteproduct(productId);
		
	}
	
	@PostMapping(path="/auth/product/update/{productId}",
			 consumes = {"application/json","application/xml"},
		      produces = {"application/json","application/xml"})
	public ProductResponse UpdateProduct(@RequestBody ProductRequest productRequest,@PathVariable Long productId)
	{
		return productservice.UpdateProduct(productId, productRequest);
	}
	
	
	
}