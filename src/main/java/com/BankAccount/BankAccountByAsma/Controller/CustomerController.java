package com.BankAccount.BankAccountByAsma.Controller;

import com.BankAccount.BankAccountByAsma.Model.Account;
import com.BankAccount.BankAccountByAsma.Model.Customer;
import com.BankAccount.BankAccountByAsma.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "Customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @RequestMapping(value = "getAll", method = RequestMethod.GET)

    public List<Customer> getAllCustomer() {

        List<Customer> customers = customerService.getAllCustomer();
        return customers;
    }
    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public Customer getCustomerById(@RequestParam Integer customerId) {
        Customer customer = customerService.getCustomertById(customerId);
        return customer;
    }
    @GetMapping(value = "addCustomer")
    public void addCustomer() {
        customerService.addCustomer();

    }
}
