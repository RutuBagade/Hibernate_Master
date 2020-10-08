package com.app.ForeignKeyAssociation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="StudentAddress")
public class StudentAddress {
	@Id
	@Column(name="id",unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
    private long id;
	@Column(name="address", unique = false, nullable = false, length = 100)
    private String address;
	@Column(name="city", unique = false, nullable = false, length = 100)
    private String city;
	@Column(name="state", unique = false, nullable = false, length = 100)
    private String state;
	@Column(name="country", unique = false, nullable = false, length = 100)
    private String country;
	@OneToOne(mappedBy="studentAddress")
    private Student student;
 
    public StudentAddress() {
 
    }
 
    public StudentAddress(String address, String city, String state,
            String country) {
        super();
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
    }
 
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    public String getAddress() {
        return address;
    }
 
    public void setAddress(String address) {
        this.address = address;
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
 
   /* public Student getStudent() {
        return student;
    }
 
    public void setStudent(Student student) {
        this.student = student;
    }
 */
}