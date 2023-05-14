package com.BankAccount.BankAccountByAsma.Service;

import com.BankAccount.BankAccountByAsma.Model.Account;
import com.BankAccount.BankAccountByAsma.Model.Customer;
import com.BankAccount.BankAccountByAsma.Model.Transaction;
import com.BankAccount.BankAccountByAsma.Repositry.AcoountRepositry;
import com.BankAccount.BankAccountByAsma.Repositry.CustomerRepositry;
import com.BankAccount.BankAccountByAsma.Repositry.TransactionRepositry;
import com.BankAccount.BankAccountByAsma.RequestObject.AccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.criteria.CriteriaBuilder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class AcoountService {
    @Autowired
    AcoountRepositry acoountRepositry;
    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerRepositry customerRepositry;
    @Autowired
    TransactionRepositry transactionRepositry;

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
    public void  addAccount(AccountRequest account) {
        Double interestVariable = 2.5; // variable for interest
        Account accountInfo = new Account();
        accountInfo.setAccountNumber(account.getAccountNumber());
        accountInfo.setInterest(interestVariable);
        Double calculateInterest=account.getBalance()*interestVariable;
        Double newBalance= account.getBalance()-calculateInterest;
        accountInfo.setBalance(newBalance);// balance * interest Variable to get the profit
        Integer id = customerRepositry.findIdByPhoneNumber(account.getPhoneNumber()); // find ID by unique variable (Phone)
        Customer customerId = customerRepositry.findById(id).get() ;
        accountInfo.setCustomer(customerId);
        accountInfo.setIsActive(account.getIsActive());
        accountInfo.setCreatedDate(new Date());
        acoountRepositry.save(accountInfo);

    }
    public Account geAccountBalanceById(Integer id){
        Account account=  acoountRepositry.findById(id).get();
        return account;
    }
    public List<Account> getCustomerAccountInformation(Integer customerId) {
        return acoountRepositry.getCustomerAccountInformation(customerId);
    }
    public String makeMonthlyStatement(Integer id) {
        Account account = acoountRepositry.findById(id).get();
        Customer customer = account.getCustomer();
        LocalDate localDate = LocalDate.now();
        LocalDate statementDate = LocalDate.of(localDate.getYear(), localDate.getMonth(), 1);

        String statementOfAccount = "Monthly Statement Of Account :" + account.getAccountNumber() +
                "\n Customer Name :" + customer.getCustomerName() +
                "\n Customer Email :" + customer.getEmail() +
                "\n Customer Phone :" + customer.getPhoneNumber() +
                "\n Date" + "\t" + localDate.getYear() + "\t" + localDate.getMonth() + "\t" + localDate.getDayOfMonth() +
                "\n Account Balance :" + account.getBalance();

        return statementOfAccount;
    }
    public List<Transaction> getAccountHistoryWithTransaction(Integer id) {
        Account account = acoountRepositry.findById(id).get(); // get the account ID
        List<Transaction> transactionList = transactionRepositry.findByAccount(account); //get the Transaction ID from Account
        return transactionList;
    }
    public Account retriveBalanceBySpacificAccount(Integer accountNumber){
        Account account = acoountRepositry.retriveBalanceBySpacificAccount(accountNumber);
        return  account;
    }




}
