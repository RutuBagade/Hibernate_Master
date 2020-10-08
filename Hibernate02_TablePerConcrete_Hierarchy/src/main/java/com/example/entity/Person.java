package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.InheritanceType;
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="perTab1")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Person {
@Id
@Column(name="pid")
private int perId;
@Column(name="pname")
private String perName;
}