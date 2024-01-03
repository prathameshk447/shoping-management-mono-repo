package org.dyanyog.services;


import java.util.Optional;


import org.dyanyog.dto.Product;
import org.dyanyog.dto.ProductRequest;
import org.dyanyog.dto.ProductResponse;
import org.dyanyog.entity.Products;
import org.dyanyog.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ProductManagementServices{

	@Autowired
	ProductRepository productRepo;
	
	
	
	
	
	public ProductResponse addProduct(ProductRequest productRequest)
	{
		ProductResponse responce = new ProductResponse();
		
		Products p = new Products();
		
		p.setProductname(productRequest.getProductname());
		p.setQuantity(productRequest.getQuantity());
		p.setType(productRequest.getType());
		p.setPrice(productRequest.getPrice());
		
		p =productRepo.save(p);
		
		responce.setStatus("Success");
		responce.setMessage("product added successfully");
		responce.setProduct_id(p.getProduct_id());
		
		return responce;
	}


    
	public Product getSingleProduct(long productId) {
    	
    	Product productResponse = new Product();
    	
    	java.util.Optional<Products> receiveData = productRepo.findById(productId);
    	
    
		if( receiveData.isEmpty()) {
    		productResponse.setStatus("Fail");
    		productResponse.setMessage("product not found");
    	}else
    	{
    		Products product = (Products) receiveData.get();
    		productResponse.setStatus("success");
    		productResponse.setMessage("product found");
    
    		productResponse.setProductname(product.getProductname());
    		productResponse.setQuantity(product.getQuantity());
    		productResponse.setType(product.getType());
    		productResponse.setPrice(product.getPrice());
    		
    		productResponse.setProduct_id(product.getProduct_id());
    		
    	}
    	return productResponse;
    	
    }
	public String deleteproduct(Long productId) {
		productRepo.deleteById(productId);
			return "The Product Id" +productId +"has been deleted";
		}

		public ProductResponse UpdateProduct(Long productId, ProductRequest request) {
			
			ProductResponse response = new ProductResponse();
			Optional<Products> receivedData = productRepo.findById(productId);
			if(receivedData.isPresent()) {
				
			Products productsTable = new Products();
			
			productsTable.setProductname(request.getProductname());
			productsTable.setType(request.getType());
			productsTable.setQuantity(request.getQuantity());
			productsTable.setPrice(request.getPrice());
			productsTable.setProduct_id(productId);
		    productsTable = productRepo.save(productsTable);
		    
		    response.setMessage("Product Information updated Successfully");
		    response.setStatus("Success");
		    response.setProduct_id(productId);
		    response.setProductname(productsTable.getProductname());
		    response.setQuantity(productsTable.getQuantity());
		    response.setType(productsTable.getType());
		    response.setPrice(productsTable.getPrice());
		    
		
		}
			return response;
		}



		
	}


	


