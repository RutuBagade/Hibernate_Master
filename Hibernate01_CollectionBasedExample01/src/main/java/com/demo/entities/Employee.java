package com.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Employee {
	@Id
	@Column
	private int id;
	@Column
	   private String firstName; 
	@Column
	   private String lastName;  
	@Column
	   private int salary;
	@ElementCollection
	@CollectionTable(name="certificatetab", joinColumns=@JoinColumn(name="id") )
	@OrderColumn(name="pos")
	@Column(name="Certificates")
	   private List<String> certificates=new ArrayList<String>();


}
