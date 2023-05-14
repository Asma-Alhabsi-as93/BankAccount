package com.BankAccount.BankAccountByAsma.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "account_transaction")
@Setter
@Getter
public class Transaction extends  BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Double amount;
    @ManyToOne
    @JoinColumn(name = "account_id",referencedColumnName="id")
    Account account;
//    public Transaction(Integer id, Date amountDate) {
//        this.id = id;
//        this.amountDate = amountDate;
//    }


}
