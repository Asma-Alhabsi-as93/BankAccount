package com.BankAccount.BankAccountByAsma.Service;

import com.BankAccount.BankAccountByAsma.Model.Account;
import com.BankAccount.BankAccountByAsma.Model.CreditCard;
import com.BankAccount.BankAccountByAsma.Model.Customer;
import com.BankAccount.BankAccountByAsma.Repositry.AcoountRepositry;
import com.BankAccount.BankAccountByAsma.Repositry.CreditCardRepository;
import com.BankAccount.BankAccountByAsma.Repositry.CustomerRepositry;
import com.BankAccount.BankAccountByAsma.RequestObject.CreditCardInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CreditCardService {
    @Autowired
    CreditCardRepository creditCardRepository;
    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerRepositry customerRepositry;
    @Autowired
    AcoountRepositry acoountRepositry;

    public List<CreditCard> getAllCreditCards() {
        return creditCardRepository.getAllCreditCards();
    }

    public CreditCard getCreditById(Integer creditId) {
        CreditCard creditCard = creditCardRepository.getCreditById(creditId);
        return creditCard;
    }

    public void addCreditCard(CreditCardInfo creditCard) {
        CreditCard creditCardInfo = new CreditCard();
        creditCardInfo.setNumber(creditCard.getCardNumber());
        String customerName = creditCard.getCustomerName();
        Integer id = customerRepositry.findByCustomerName(customerName);
        Customer customerId = customerRepositry.findById(id).get();
        Double balance = acoountRepositry.getBalanceByCustomerId(id);
        creditCardInfo.setCreditCardBalanse(balance);
        creditCardInfo.setIsActive(creditCard.getIsActive());
        creditCardInfo.setCustomer(customerId);
        creditCardRepository.save(creditCardInfo);


    }
}


