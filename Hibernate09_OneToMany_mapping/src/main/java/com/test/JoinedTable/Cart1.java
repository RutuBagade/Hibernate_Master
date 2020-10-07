package com.test.JoinedTable;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="CART")
public class Cart1 {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cart_id")
	private long id;
	
	@Column(name="total")
	private double total;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL)
	 @JoinTable(name="CART_ITEMS", joinColumns={@JoinColumn(name="CART_cart_id", referencedColumnName="cart_id")}
	    , inverseJoinColumns={@JoinColumn(name="ITEMS_id", referencedColumnName="id")})
	private Set<Items1> items1;
}