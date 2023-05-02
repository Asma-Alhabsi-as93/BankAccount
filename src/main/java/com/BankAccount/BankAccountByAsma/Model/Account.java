package com.BankAccount.BankAccountByAsma.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Getter
@Setter
public class Account extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id ;
    Integer balance;
    Integer accountNumber;
    @ManyToOne
            @JoinColumn(name = "customer_id",referencedColumnName="id")
Customer customer;
//    public Account(Integer id, Integer balance, Integer accountNumber) {
//        this.id = id;
//        this.balance = balance;
//        this.accountNumber = accountNumber;
//    }




}
