package com.app.joinedTable;

import javax.persistence.*;  

@Entity  
@Table(name="address220")  
public class AddressPK {    
      
    @Id  
    @GeneratedValue(strategy=GenerationType.IDENTITY)  
    @Column(name="addressId")
private int addressId;    
    @Column
private String addressLine1,city,state,country; 
    @Column
private int pincode; 
    @OneToOne(mappedBy="address",cascade=CascadeType.ALL)
    private EmployeePk employee;
  

public EmployeePk getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeePk employee) {
		this.employee = employee;
	}
public int getAddressId() {  
    return addressId;  
}  
public void setAddressId(int addressId) {  
    this.addressId = addressId;  
}  
public String getAddressLine1() {  
    return addressLine1;  
}  
public void setAddressLine1(String addressLine1) {  
    this.addressLine1 = addressLine1;  
}  
public String getCity() {  
    return city;  
}  
public void setCity(String city) {  
    this.city = city;  
}  
public String getState() {  
    return state;  
}  
public void setState(String state) {  
    this.state = state;  
}  
public String getCountry() {  
    return country;  
}  
public void setCountry(String country) {  
    this.country = country;  
}  
public int getPincode() {  
    return pincode;  
}  
public void setPincode(int pincode) {  
    this.pincode = pincode;  
}  

}  