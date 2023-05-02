package com.BankAccount.BankAccountByAsma.Repositry;

import com.BankAccount.BankAccountByAsma.Model.Account;
import com.BankAccount.BankAccountByAsma.Model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard,Integer> {
    @Query(value = "SELECT s from CreditCard s")
    List<CreditCard> getAllCreditCards();
    @Query(value = "SELECT s from CreditCard s where s.id =:creditId")
    CreditCard getCreditById(@Param("creditId")Integer creditId);
}
