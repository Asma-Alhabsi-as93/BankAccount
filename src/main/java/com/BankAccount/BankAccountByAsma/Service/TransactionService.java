package com.BankAccount.BankAccountByAsma.Service;

import com.BankAccount.BankAccountByAsma.Model.Account;
import com.BankAccount.BankAccountByAsma.Model.Transaction;
import com.BankAccount.BankAccountByAsma.Repositry.AcoountRepositry;
import com.BankAccount.BankAccountByAsma.Repositry.CustomerRepositry;
import com.BankAccount.BankAccountByAsma.Repositry.TransactionRepositry;
import com.BankAccount.BankAccountByAsma.RequestObject.TransactionRequest;
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
    @Autowired
    AcoountRepositry acoountRepositry;


    public List<Transaction> getAllTransaction() {

        return transactionRepositry.getAllTransaction();
    }

//    public void addTransaction() {
//        Transaction transaction = new Transaction();
//        transaction.setId(5);
//        transaction.setAmountDate(new Date());
//        transactionRepositry.save(transaction);
//
//    }
    public String createTransaction(TransactionRequest transactionRequest){
        Transaction transaction=new Transaction();
        transaction.setAmount(transactionRequest.getAmount());
        Integer id=acoountRepositry.getAccountByAccountNumber(transactionRequest.getAccountNumber());
        Account account=acoountRepositry.findById(id).get();
        transaction.setIsActive(account.getIsActive()); // if account is active then transaction is active
        transaction.setAccount(account);
        Double transactionAmount= transactionRequest.getAmount();
        Double accountBalance=account.getBalance();
        Double newBalance=accountBalance-transactionAmount;
        account.setBalance(newBalance);
  transaction.setCreatedDate(new Date());

        acoountRepositry.save(account);
        transactionRepositry.save(transaction);
        return "Transaction done successfully";

    }
}
