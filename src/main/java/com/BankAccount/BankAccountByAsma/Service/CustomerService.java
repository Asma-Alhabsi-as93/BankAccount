package com.BankAccount.BankAccountByAsma.Service;

import com.BankAccount.BankAccountByAsma.Model.Account;
import com.BankAccount.BankAccountByAsma.Model.CreditCard;
import com.BankAccount.BankAccountByAsma.Model.Customer;
import com.BankAccount.BankAccountByAsma.Repositry.CustomerRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    CustomerRepositry customerRepositry;
    public List<Customer> getAllCustomer() {
        return customerRepositry.getAllCustomer();
    }
    public Customer getCustomertById(Integer customerId) {
        Customer customer = customerRepositry.getCustomerById(customerId);
        return customer;
    }
}
