package com.app.joinedTable;
import javax.persistence.*; 
@Entity  
@Table(name="EmpJoinTable")  
public class EmployeePk {    
      
    @Id  
    @GeneratedValue(strategy=GenerationType.IDENTITY)  
    @Column(name="employeeId")
private int employeeId; 
  @Column
private String name,email;  
  
  @OneToOne(cascade=CascadeType.ALL)
  @JoinTable(name="Employee_Address",
  joinColumns=@JoinColumn(name="EmployeePk_employeeId"),
  inverseJoinColumns=@JoinColumn(name="AddressPK_addressId"))
  private AddressPK address;
 
public AddressPK getAddress() {
	return address;
}
public void setAddress(AddressPK address) {
	this.address = address;
}
public int getEmployeeId() {  
    return employeeId;  
}  
public void setEmployeeId(int employeeId) {  
    this.employeeId = employeeId;  
}  
public String getName() {  
    return name;  
}  
public void setName(String name) {  
    this.name = name;  
}  
public String getEmail() {  
    return email;  
}  
public void setEmail(String email) {  
    this.email = email;  
}  
   
  
}    