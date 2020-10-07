package com.example.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@DiscriminatorValue(value="CCARD")
public class CreditCardPayment  extends Payment{
    
    @Column(name="ccnumber")
    private int cardNumer;
    
    @Column(name="cctype",length=10)
    private String cardType;
}