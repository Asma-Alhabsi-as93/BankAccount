package com.BankAccount.BankAccountByAsma.Service;

import com.BankAccount.BankAccountByAsma.Model.Account;
import com.BankAccount.BankAccountByAsma.Model.CreditCard;
import com.BankAccount.BankAccountByAsma.Repositry.CreditCardRepository;
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
    public List<CreditCard> getAllCreditCards() {
      return creditCardRepository.getAllCreditCards();
    }
    public CreditCard getCreditById(Integer creditId) {
        CreditCard creditCard = creditCardRepository.getCreditById(creditId);
        return creditCard;
    }
    public void addCreditCard() {
        CreditCard creditCard = new CreditCard();
        creditCard.setId(7);
        creditCard.setLimit(30);
        creditCard.setNumber(16);
        creditCard.setCreatedDate(new Date());
        creditCard.setIsActive(true);
        creditCard.setCustomer(customerService.getCustomertById(3));
        creditCardRepository.save(creditCard);

    }
}


