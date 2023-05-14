package com.BankAccount.BankAccountByAsma.Controller;

import com.BankAccount.BankAccountByAsma.Model.Account;
import com.BankAccount.BankAccountByAsma.Model.Transaction;
import com.BankAccount.BankAccountByAsma.RequestObject.TransactionRequest;
import com.BankAccount.BankAccountByAsma.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "Transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @RequestMapping(value = "getAll", method = RequestMethod.GET)

    public List<Transaction> getAllTransaction() {

        List<Transaction> transactions = transactionService.getAllTransaction();
        return transactions;
    }

//    @GetMapping(value = "addTransaction")
//    public void addTransaction() {
//        transactionService.addTransaction();
//        transactionService.addTransaction();
//
//    }

    @RequestMapping(value = "makeTransaction", method = RequestMethod.POST)
    public String makeTransaction(@RequestBody TransactionRequest transactionRequest) {
        try {
            transactionService.createTransaction(transactionRequest);
            return "Transaction made Successfully";
        } catch (Exception e) {
            return "Transaction Failed";
        }
    }
}
