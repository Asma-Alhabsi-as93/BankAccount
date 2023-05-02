package com.BankAccount.BankAccountByAsma.Repositry;

import com.BankAccount.BankAccountByAsma.Model.Account;
import com.BankAccount.BankAccountByAsma.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepositry extends JpaRepository<Customer,Integer> {
    @Query(value = "SELECT s from Customer s")
    List<Customer>getAllCustomer();
    @Query(value = "SELECT s from Customer s where s.id =:customerId")
    Customer getCustomerById(@Param("customerId")Integer accountcustomerIdId);
}