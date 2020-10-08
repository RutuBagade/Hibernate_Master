package com.test.foreignKeyBidirectionalAssociation;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor  

@Entity
@Table(name="customers")
public class Customer {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id", unique = true, nullable = false)
    private int cid;
	 @Column(name = "Customer_Name", unique = false, nullable = false, length = 100)
	 private String cname;
	 @ManyToOne
	private Vendor vendor;
}