package com.BankAccount.BankAccountByAsma.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
public class Customer extends  BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String customerName;
    Integer phoneNumber;
    String email;
//    public Customer(Integer id, String customerName, Integer phoneNumber, String email) {
//        this.id = id;
//        this.customerName = customerName;
//        this.phoneNumber = phoneNumber;
//        this.email = email;
//    }






}
