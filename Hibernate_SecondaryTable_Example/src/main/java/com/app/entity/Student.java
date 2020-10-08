package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="studentTab")
@SecondaryTables({
@SecondaryTable(name="studentTwo"),
@SecondaryTable(name="studentExtraInfo",pkJoinColumns=@PrimaryKeyJoinColumn(name="studidfk"))
})
public class Student {
	@Id
	@Column(name="studid")
	private int studentId;
	
	@Column(name="studname")
	private String studentName;
	
	@Column(name="studsal",table="studentTwo")
	private double studentSal;
	
	@Column(name="proj",table="studentextraInfo")
	private String prjs;
	
	@Column(name="studdept",table="studentextrainfo")
	private String dept;
}