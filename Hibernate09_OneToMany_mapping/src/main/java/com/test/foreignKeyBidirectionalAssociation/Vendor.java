package com.test.foreignKeyBidirectionalAssociation;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="vendor")
public class Vendor {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vid", unique = true, nullable = false)
 private int vendid;
	
	 @Column(name = "VENDOR_NAME", unique = false, nullable = false, length = 100)
     private String name;
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="vendor_vid")
    private Set<Customer> children;
}
