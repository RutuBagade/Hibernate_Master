package com.test.ForeignkeyUnidirectionalAssociation;

import javax.persistence.*;  
import java.util.List;    
  
@Entity  
@Table(name="Question")  
public class Question {    
  
@Id   
@GeneratedValue(strategy=GenerationType.IDENTITY)  
@Column(name="id")
private int id;    
@Column
private String qname;    
  
@OneToMany(cascade = CascadeType.ALL)  
private List<Answer> answers;  
public int getId() {  
    return id;  
}  
public void setId(int id) {  
    this.id = id;  
}  
public String getQname() {  
    return qname;  
}  
public void setQname(String qname) {  
    this.qname = qname;  
}  
public List<Answer> getAnswers() {  
    return answers;  
}  
public void setAnswers(List<Answer> answers) {  
    this.answers = answers;  
}      
}  