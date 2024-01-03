package org.dyanyog.repo;



import org.dyanyog.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface OrderRepository extends JpaRepository<Orders, Long> {
	
	
	
	
	
	

	
	Orders save(Orders o);

	
}
