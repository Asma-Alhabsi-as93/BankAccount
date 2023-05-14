package com.BankAccount.BankAccountByAsma.Controller;

import com.BankAccount.BankAccountByAsma.Model.Account;
import com.BankAccount.BankAccountByAsma.Model.Customer;
import com.BankAccount.BankAccountByAsma.Model.Loan;
import com.BankAccount.BankAccountByAsma.RequestObject.AccountRequest;
import com.BankAccount.BankAccountByAsma.Service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "Loan")
public class LoanController {
    @Autowired
    LoanService loanService;

    @RequestMapping(value = "getAll", method = RequestMethod.GET)

    public List<Loan> getAllLoan() {
        List<Loan> loans = loanService.getAllLoan();
        return loans;
    }

//    @RequestMapping(value = "addLoan", method = RequestMethod.POST)
//    public String addLoan(@RequestBody AccountRequest account) {
//        try {
//            loanService.addLoan(loan);
//            return "Account added Successfully";
//        } catch (Exception e) {
//            return "Account added Failed";
//        }
//    }
}
