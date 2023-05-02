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
public class Loan extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Integer amount;
    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName="id")
    Customer customer;

//    public Loan(Integer id, Integer amount, Date insertDate) {
//        this.id = id;
//        this.amount = amount;
//        this.insertDate = insertDate;
//    }

    Date insertDate;
}
