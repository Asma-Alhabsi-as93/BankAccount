package com.BankAccount.BankAccountByAsma.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity

@Data
@Getter
@Setter
public class CreditCard extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Double creditCardBalanse;
    Integer number;
    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName="id")
    Customer customer;
//    public CriditCard(Integer id, Integer limit, Integer number) {
//        this.id = id;
//        this.limit = limit;
//        this.number = number;
//    }


}
