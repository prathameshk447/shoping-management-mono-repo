package org.dyanyog.repo;



import org.dyanyog.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface ProductRepository extends JpaRepository<Products, Long> {
	
	
	
	
	
	

	
	Products save(Products p);

	
}
