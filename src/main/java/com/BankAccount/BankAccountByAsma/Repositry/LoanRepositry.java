package com.BankAccount.BankAccountByAsma.Repositry;

import com.BankAccount.BankAccountByAsma.Model.Account;
import com.BankAccount.BankAccountByAsma.Model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LoanRepositry extends JpaRepository<Loan,Integer> {
    @Query(value = "SELECT s from Loan s")
    List<Loan> getAllLoan();
}
