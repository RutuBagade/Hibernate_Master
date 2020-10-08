package com.test.Entities;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Customer")
public class Customer {
	@Id
	@Column(name="custId")
	private int custId;
	@Column(name="custName")
	private String custName;
	
	@ElementCollection
	@CollectionTable(name="custData",
	joinColumns=@JoinColumn(name="custId"))
    @Column(name="data")
	private Set<String> custData=new HashSet<String>();
	
	@ElementCollection
	@CollectionTable(name="mapTab",
	joinColumns=@JoinColumn(name="custId"))
    @MapKeyColumn(name="pos")
    @Column(name="data")
    private Map<Integer,String> Data=new TreeMap<Integer,String>();
}
