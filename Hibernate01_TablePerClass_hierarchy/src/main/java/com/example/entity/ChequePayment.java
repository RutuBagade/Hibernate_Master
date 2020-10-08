package com.example.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor 

@Entity
@DiscriminatorValue(value="CHQ")
public class ChequePayment extends Payment {

    @Column(name="chqnumber")
    private int chequeNumber;
    
    @Column(name="chtype",length=10)
    private String chequeType;
}