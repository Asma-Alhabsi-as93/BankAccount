package com.BankAccount.BankAccountByAsma.Repositry;

import com.BankAccount.BankAccountByAsma.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AcoountRepositry extends JpaRepository<Account,Integer> {
    @Query(value = "SELECT s from Account s")
    List<Account> getAllAccount();

    @Query(value = "SELECT s from Account s where s.id =:accountId")
    Account getAccountById(@Param("accountId")Integer accountId);

    @Query(value = "SELECT s from Account s where s.isActive = 1")
    List<Account> getAllActiveaAccount();

    @Query(value = "SELECT s from Account s where s.isActive = 0")
    List<Account> getAllInActiveSchools();
    @Query(value ="SELECT s from Account s where s.id=(SELECT max(s.id) from Account s)")
    Account getLatestRow();
    @Query(value ="SELECT s from Account s where s.updatedDate = (SELECT max(s.updatedDate) from Account s)")
    Account getLatestUpdated();


}
