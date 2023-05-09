package com.BankAccount.BankAccountByAsma.Controller;

import com.BankAccount.BankAccountByAsma.Model.Account;
import com.BankAccount.BankAccountByAsma.RequestObject.AccountRequest;
import com.BankAccount.BankAccountByAsma.Service.AcoountService;
import com.BankAccount.BankAccountByAsma.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
/*
import org.springframework.security.access.prepost.PreAuthorize;
*/
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping(value = "account")

public class AccountController {
    @Autowired
    AcoountService acoountService;
    @Autowired
    SlackClient slackClient;

    @RequestMapping(value = "getAll", method = RequestMethod.GET)

    public List<Account> getAllAccount() {

        List<Account> accounts = acoountService.getAllAccount();
        return accounts;
    }

    @RequestMapping(value = "getById", method = RequestMethod.GET)
    public Account getAccountById(@RequestParam Integer accountId) {
        Account account = acoountService.getAccountById(accountId);
        return account;
    }

    @RequestMapping(value = "getByActive")
    public List<Account> getByActive() {
        List<Account> activeAccountList = acoountService.getByActive();
        return activeAccountList;
    }

    @RequestMapping(value = "getByInActive")
    public List<Account> getByInActive() {
        List<Account> inActiveSchoolsList = acoountService.getByInActive();
        return inActiveSchoolsList;
    }

    @RequestMapping(value = "getLatestRow", method = RequestMethod.GET)
    public Account getLatestRow() {
        Account account = acoountService.getLatestRow();
        return account;

    }

    @RequestMapping(value = " getLatestUpdated", method = RequestMethod.GET)
    public Account getLatestUpdated() {
        Account account = acoountService.getLatestUpdated();
        return account;
    }
    @RequestMapping(value = "addAccount", method = RequestMethod.POST)
    public String addAccount(@RequestBody AccountRequest account) {
        try {
            acoountService.addAccount(account);
            return "Account added Successfully";
        } catch (Exception e) {
            return "Account added Failed";
        }
    }
    @RequestMapping(value = "geAccountBalanceById", method = RequestMethod.GET)
    //@PreAuthorize("hasRole('USER')")
    public Account geAccountBalanceById(@RequestParam Integer id) {
        Account account = acoountService.geAccountBalanceById(id);
        return account;

    }

    @RequestMapping(value = "makeMonthlyStatement", method = RequestMethod.GET)
    public ResponseEntity<String> makeMonthlyStatement(@RequestParam Integer accountId) {
        String statement = acoountService.makeMonthlyStatement(accountId);
        return ResponseEntity.ok(statement);
    }
}
