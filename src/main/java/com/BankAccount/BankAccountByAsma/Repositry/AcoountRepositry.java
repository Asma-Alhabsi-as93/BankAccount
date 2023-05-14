package com.BankAccount.BankAccountByAsma.Repositry;

import com.BankAccount.BankAccountByAsma.Model.Account;
import com.BankAccount.BankAccountByAsma.Model.Customer;
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

    @Query(value = "SELECT s from Account s where s.id =:id")
    Account geAccountBalanceById(@Param("id") Integer id);

    @Query(value = "Select a From Account a WHERE a.customer.id = :id")
    List<Account> getCustomerAccountInformation(@Param("id") Integer customerId);

    @Query(value = " select id from account where account_number=:accountNumber",nativeQuery = true)
    Integer getAccountByAccountNumber(@Param("accountNumber") Integer accountNumber);

    @Query(value = "Select s from Account s Where s.accountNumber = :accountNumber")
    Account retriveBalanceBySpacificAccount(@Param("accountNumber") Integer accountNumber);

    @Query(value = "Update Account c SET c.isActive=0 WHERE c.id = :id")
    void deleteAccount(@Param("id")Integer id);
    List<Account> getAllByCustomer(Customer customer);

    @Query(value = "Select a from Account a Where a.customer.id = :customerId")
    Account getAccountByCustomerId(@Param("customerId") Integer customerId);

    @Query(value = "Select account_balance from account Where customer_id = :customerId", nativeQuery = true)
    Double getBalanceByCustomerId(@Param("customerId") Integer customerId);
}
