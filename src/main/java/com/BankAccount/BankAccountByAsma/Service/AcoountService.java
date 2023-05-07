package com.BankAccount.BankAccountByAsma.Service;

import com.BankAccount.BankAccountByAsma.Model.Account;
import com.BankAccount.BankAccountByAsma.Repositry.AcoountRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class AcoountService {
    @Autowired
    AcoountRepositry acoountRepositry;
    @Autowired
    CustomerService customerService;

    public List<Account> getAllAccount() {
        return acoountRepositry.getAllAccount();
    }

    public Account getAccountById(Integer accountId) {
        Account account = acoountRepositry.getAccountById(accountId);
        return account;
    }

    public List<Account> getByActive() {
        return acoountRepositry.getAllActiveaAccount();

    }

    public List<Account> getByInActive() {
        return acoountRepositry.getAllInActiveSchools();

    }

    public Account getLatestRow() {
        Account account = acoountRepositry.getLatestRow();
        return account;
    }

    public Account getLatestUpdated() {
        Account account = acoountRepositry.getLatestUpdated();
        return account;
    }

    //    public void deleteAccountById(Integer id) {
//        Account accountToDelete = acoountRepositry.findById(id).get();
//        accountToDelete.setActive(false);
//        acoountRepositry.save(accountToDelete);
//    }
    public void addAccount() {
        Account account = new Account();
        account.setId(7);
        account.setBalance(50);
        account.setAccountNumber(0065443);
        account.setCreatedDate(new Date());
        account.setIsActive(true);
        account.setCustomer(customerService.getCustomertById(6));
        acoountRepositry.save(account);

    }
    public Account geAccountBalance(Integer accountBalance){
        Account account=  acoountRepositry.geAccountBalance(accountBalance);
        return account;
    }
}
