package com.CodeMer;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManagerFactory;

import java.util.*;
import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch.TaskInfo;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class customerRewardManagementServices {
	@Autowired
	private customerRewardManagementRepository customerRepo;
	
	public void save(Customer customer) {
		customerRepo.save(customer);
		
	}
	public List listAll(){
		
		return customerRepo.findAll();
		
	}
	
	public List<Customer> getallCustomers() {
		return customerRepo.findAll();
	}
	public void delete(int id) {
		customerRepo.deleteById((long) id);
	}

	
	
	public static int rewardCalculator(int amountPurchased) {
		if(amountPurchased>100) {
			int rewards=(50*1)+(amountPurchased-100)*2;
			return rewards;
		}
		else if(amountPurchased<100 && amountPurchased>50 ) {
			int rewards=(amountPurchased-50)*1;
			return rewards;
		}
		else {
			int rewards=0;
		return rewards;
		}
	}
	
	
	   public List<Customer> rewardReportGenerator(){
		List rewardReort=customerRepo.findAllCustomer();
				return rewardReort;
		}
	
	//using java 8 groupinby
	public static Map groupingById(List objectList) {
		
		System.out.println(objectList.get(0));
           
		Map<String, Customer> customersSortedById =   (Map<String, Customer>) objectList.stream()
				  .collect(Collectors.groupingBy(Customer::getCustomerId));
		System.out.println(customersSortedById.get(7878));
		//ma variable returnKey and value pair(customerId,Object)
		return customersSortedById;
		}
	
	//tosubstring the date to YYYY-MM
	public Map individualrewardsfinder(List customerObjList){
		
		
        Map<String, Integer> dates = new HashMap<String, Integer>();
        
        for(Object customerObj : customerObjList) {
	     Customer c1=(Customer)customerObj;
	   dates.put(c1.getDateOfPurchase().toString(),c1.getRewardPoints());
	   
        }
      //tosubstring the date to YYYY-MM
    	
       Map<String, Integer> result = new HashMap<String, Integer>();

       for (Entry<String, Integer> entry  : dates.entrySet()) {
       String key = entry.getKey().split("-")[0] + "/" + entry.getKey().split("-")[1];
       Integer value = entry.getValue();
       Integer oldValue = result.get(key) != null ? result.get(key) : 0;
       result.put(key, oldValue + value);
      }

       for (Entry<String, Integer> entry  : result.entrySet()) {
       System.out.println("Month " + entry.getKey() + "- Value = " + entry.getValue());
       }
    
        return result;
	}
	
	
	
}
