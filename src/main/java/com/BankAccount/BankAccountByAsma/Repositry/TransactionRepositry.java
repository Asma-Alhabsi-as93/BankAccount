package com.BankAccount.BankAccountByAsma.Repositry;

import com.BankAccount.BankAccountByAsma.Model.Account;
import com.BankAccount.BankAccountByAsma.Model.Loan;
import com.BankAccount.BankAccountByAsma.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepositry extends JpaRepository<Transaction,Integer> {
    @Query(value = "SELECT s from Transaction s")
    List<Transaction> getAllTransaction();

    List<Transaction> findByAccount(Account account); // get the Transaction list from account
}
