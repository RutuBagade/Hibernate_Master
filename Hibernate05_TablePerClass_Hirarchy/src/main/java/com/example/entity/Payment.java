package com.example.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.DiscriminatorType;
import javax.persistence.InheritanceType; 

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "payment")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "paymode", discriminatorType = DiscriminatorType.STRING, length = 6)

public class Payment {
    @Id
    @Column(name = "payid")
    private Integer paymentId;
    @Column(name = "amount")
    private Double amount;
}
