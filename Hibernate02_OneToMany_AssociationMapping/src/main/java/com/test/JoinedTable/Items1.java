package com.test.JoinedTable;


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
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Data
@NoArgsConstructor

@RequiredArgsConstructor
@Entity
@Table(name="ITEMS")
public class Items1 {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	@Column(name="item_id")
	@NonNull
	private String itemId;
	
	@Column(name="item_total")
	@NonNull
	private double itemTotal;
	
	@Column(name="quantity")
	@NonNull
	private int quantity;
	
	
}