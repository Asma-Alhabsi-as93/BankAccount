package com.BankAccount.BankAccountByAsma.Controller;

import com.BankAccount.BankAccountByAsma.Model.Account;
import com.BankAccount.BankAccountByAsma.Model.CreditCard;
import com.BankAccount.BankAccountByAsma.RequestObject.CreditCardInfo;
import com.BankAccount.BankAccountByAsma.Service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "CreditCard")
public class CreditCardController {
    @Autowired
    CreditCardService creditCardService;

    @RequestMapping(value = "getAll", method = RequestMethod.GET)
    public List<CreditCard> getAllCreditCards() {

        List<CreditCard> creditCards = creditCardService.getAllCreditCards();
        return creditCards;
    }
    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public CreditCard getCreditById(@RequestParam Integer creditId) {
        CreditCard creditCard = creditCardService.getCreditById(creditId);
        return creditCard;
    }
 @RequestMapping(value = "addCreditCard", method = RequestMethod.POST)
    public String addCreditCard(@RequestBody CreditCardInfo creditCard) {
        creditCardService.addCreditCard(creditCard);
        String creditCards = "CreditCard Add Successfully";
        return creditCards;

    }

}
