package com.app.ForeignKeyAssociation;
import javax.persistence.*;  
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="Student")
public class Student {
	@Id
	
	@Column(name="student_id",unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
	@Column(name="first_name",unique = false, nullable = false, length = 25)
    private String firstName;
	@Column(name="last_name",unique = false, nullable = false, length = 25)
    private String lastName;
	@Column(name="email",unique = false, nullable = false, length = 25)
    private String email;
	@Column(name="phone")
    private String phone;
	@OneToOne
	private StudentAddress studentAddress;
 
	public Student()
	{
		
	}
    public Student(String firstName, String lastName, String email, String phone) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }
 
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public String getPhone() {
        return phone;
    }
 
    public void setPhone(String phone) {
        this.phone = phone;
    }
 
    public StudentAddress getStudentAddress() {
        return studentAddress;
    }
 
    public void setStudentAddress(StudentAddress studentAddress) {
        this.studentAddress = studentAddress;
    }
 
}