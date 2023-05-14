package com.BankAccount.BankAccountByAsma.Service;

import com.BankAccount.BankAccountByAsma.Model.Account;
import com.BankAccount.BankAccountByAsma.Model.Customer;
import com.BankAccount.BankAccountByAsma.Model.Loan;
import com.BankAccount.BankAccountByAsma.Repositry.LoanRepositry;
import com.BankAccount.BankAccountByAsma.RequestObject.AccountRequest;
import com.BankAccount.BankAccountByAsma.RequestObject.LoanRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LoanService {
    @Autowired
    LoanRepositry loanRepositry;
    public List<Loan> getAllLoan() {
        return loanRepositry.getAllLoan();
    }


}
