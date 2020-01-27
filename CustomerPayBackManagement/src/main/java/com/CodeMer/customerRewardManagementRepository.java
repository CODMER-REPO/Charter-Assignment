package com.CodeMer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Repository
public interface customerRewardManagementRepository extends JpaRepository<Customer, Long>{
	@Query(value = "SELECT c.customer_name,sum(c.reward_points),c.customer_id, sum(c.amount_purchased),MONTH(c.date_of_purchase) as Month FROM Customer c group by c.customer_id, MONTH(c.date_of_purchase)", nativeQuery=true)
	List findAllCustomer();
	
	@Query(value = "SELECT c FROM Customer c", nativeQuery=true)
	List<Customer> AllCustomer();
}
