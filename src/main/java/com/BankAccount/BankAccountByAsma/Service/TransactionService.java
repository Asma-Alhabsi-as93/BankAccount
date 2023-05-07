package com.BankAccount.BankAccountByAsma.Service;

import com.BankAccount.BankAccountByAsma.Model.Account;
import com.BankAccount.BankAccountByAsma.Model.Transaction;
import com.BankAccount.BankAccountByAsma.Repositry.CustomerRepositry;
import com.BankAccount.BankAccountByAsma.Repositry.TransactionRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    TransactionRepositry transactionRepositry;

    @Autowired
    CustomerRepositry customerRepositry;


    public List<Transaction> getAllTransaction() {

        return transactionRepositry.getAllTransaction();
    }

    public void addTransaction() {
        Transaction transaction = new Transaction();
        transaction.setId(5);
        transaction.setAmountDate(new Date());
        transactionRepositry.save(transaction);

    }
}
