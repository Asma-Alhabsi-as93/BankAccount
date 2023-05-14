package com.BankAccount.BankAccountByAsma.Controller;

import com.BankAccount.BankAccountByAsma.Model.Account;
import com.BankAccount.BankAccountByAsma.Model.Customer;
import com.BankAccount.BankAccountByAsma.RequestObject.UpdateCustomerInfo;
import com.BankAccount.BankAccountByAsma.Service.AcoountService;
import com.BankAccount.BankAccountByAsma.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "Customer")
public class CustomerController {
    @Autowired
    AcoountService acoountService;
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
    @RequestMapping(value = "getCustomerByCustomerName", method = RequestMethod.GET)
    public Customer getCustomerByCustomerName(@RequestParam String customerName) {
        return customerService.getCustomerByCustomerName(customerName);
    }
    @RequestMapping(value = "updateCustomer", method = RequestMethod.POST)
    public String updateCustomer(@RequestBody UpdateCustomerInfo updateCustomerInfo) {
        try {
            customerService.updateCustomer(updateCustomerInfo);
            return "Customer Updated Successfully";
        } catch (Exception e) {
            return "Customer Updated Failed";
        }
    }

    @RequestMapping(value = "getCustomerAccountInformation", method = RequestMethod.GET)
    public List<Account> getCustomerAccountInformation(Integer customerId) {
        List<Account> accountList = acoountService.getCustomerAccountInformation(customerId);
        return accountList;
    }
    @RequestMapping(value = "deleteCustomer", method = RequestMethod.POST)
    public String deleteCustomer(@RequestParam Integer id) {
        try {
            customerService.deleteCustomer(id);
            return "Customer Updated Successfully";
        } catch (Exception e) {
            return "Customer Updated Failed";
        }
    }
    @RequestMapping(value = "getCustomerHistory", method = RequestMethod.GET)
    public List<Account> getCustomerHistory(@RequestParam Integer customerId) {
        List<Account> account = customerService.getAccountHistory(customerId);
        return account;
    }

}
