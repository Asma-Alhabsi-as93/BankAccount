package com.BankAccount.BankAccountByAsma.Service;

import com.BankAccount.BankAccountByAsma.Model.Account;
import com.BankAccount.BankAccountByAsma.Model.CreditCard;
import com.BankAccount.BankAccountByAsma.Repositry.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardService {
    @Autowired
    CreditCardRepository creditCardRepository;
    public List<CreditCard> getAllCreditCards() {
      return creditCardRepository.getAllCreditCards();
    }
    public CreditCard getCreditById(Integer creditId) {
        CreditCard creditCard = creditCardRepository.getCreditById(creditId);
        return creditCard;
    }
}


