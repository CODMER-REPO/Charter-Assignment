package com.CodeMer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class customerRewardManagementController {
    @Autowired
	private customerRewardManagementServices customerServices;
	
	@PostMapping(value="/newTransaction")
	public void saveNewTransaction(@RequestBody Customer customer) {
		
		int rewardsEarned=customerServices.rewardCalculator(customer.getAmountPurchased());
		customer.setRewardPoints(rewardsEarned);
		customerServices.save(customer);
		
	}
	
	
	  @GetMapping(value="/getRewardsReort")
	  public List getRewardReort() {
		
		List RewardReport =customerServices.rewardReportGenerator();
				
        return RewardReport;
		
		}
	  
	  @GetMapping(value="/getAllCustomers")
	  public List getAllCustomers() {
		
		return customerServices.getallCustomers();	
		}
	  
	  
	  /*@GetMapping(value="/getRewardsReort/{customerId}")
		public List getRewardReort(@PathVariable("customerId") int customerId) {
			//Customer customerObjList=customerServices.get(id);
			List customerObjList= customerServices.getObjectsById(customerId);
		  
			return customerObjList;
		}
		*/
	
	
}
