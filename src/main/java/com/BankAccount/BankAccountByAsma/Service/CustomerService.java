package com.BankAccount.BankAccountByAsma.Service;

import com.BankAccount.BankAccountByAsma.Model.Account;
import com.BankAccount.BankAccountByAsma.Model.CreditCard;
import com.BankAccount.BankAccountByAsma.Model.Customer;
import com.BankAccount.BankAccountByAsma.Repositry.CustomerRepositry;
import com.BankAccount.BankAccountByAsma.RequestObject.UpdateCustomerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public void addCustomer() {
        Customer customer = new Customer();
        customer.setId(7);
        customer.setCustomerName("Jamaal Alkasbi");
        customer.setEmail("jamal.ksabi@gmail.com");
        customer.setPhoneNumber(+3439873);
        customer.setCreatedDate(new Date());
        customer.setIsActive(true);
        customerRepositry.save(customer);

    }
    public Customer getCustomerByCustomerName(String customerName) {
        return customerRepositry.getCustomerByCustomerName(customerName);
    }
    public void updateCustomer(UpdateCustomerInfo customer) {
        Customer customerInfo = new Customer();
        customerInfo.setId(customer.getId());
        customerInfo.setCustomerName(customer.getName());
        customerInfo.setEmail(customer.getEmail());
        customerInfo.setPhoneNumber(customer.getPhone());
        customerInfo.setIsActive(customer.getIsActive());
        customerInfo.setCreatedDate(customer.getCreatedDate());
        customerRepositry.save(customerInfo);

    }
    public void deleteCustomer(Integer id) {
        Customer customer = customerRepositry.findById(id).get();
        customer.setIsActive(Boolean.valueOf("false"));
        customerRepositry.save(customer);
    }
}
