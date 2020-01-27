package com.CodeMer;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.repository.Temporal;

@Entity
public class Customer implements Serializable {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long transactionId;
	
	private int customerId;
	
	private String customerName;
	
	private int amountPurchased;
	
	
	@CreationTimestamp
	private Date dateOfPurchase;
	
	private int rewardPoints;
	
	public int getRewardPoints() {
		return rewardPoints;
	}
	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}
	public Long getTransactionId() {
		
		return transactionId;
	}
	
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getAmountPurchased() {
		return amountPurchased;
	}
	public void setAmountPurchased(int amountPurchased) {
		this.amountPurchased = amountPurchased;
	}
	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}
	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}
	@Override
	public String toString() {
		return "Customer [transactionId=" + transactionId + ", customerId=" + customerId + ", customerName="
				+ customerName + ", amountPurchased=" + amountPurchased + ", dateOfPurchase=" + dateOfPurchase
				+ ", rewardPoints=" + rewardPoints + "]";
	}
	
	
	
	
}
