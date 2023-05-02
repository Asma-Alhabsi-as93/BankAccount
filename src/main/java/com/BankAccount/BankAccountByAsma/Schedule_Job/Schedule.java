package com.BankAccount.BankAccountByAsma.Schedule_Job;

import com.BankAccount.BankAccountByAsma.Model.Account;
import com.BankAccount.BankAccountByAsma.Service.*;
import com.BankAccount.BankAccountByAsma.Slack.SlackClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@Component
public class Schedule {
    @Autowired
    SlackClient slackClient;
    @Autowired
    CustomerService customerService;
    @Autowired
    AcoountService acoountService;
    @Autowired
    CreditCardService creditCardService;
    @Autowired
    TransactionService transactionService;
    @Autowired
    LoanService loanService;

    @Scheduled(cron = "0 0/1 * * * *")
    @RequestMapping(value = "getAll", method = RequestMethod.GET)

    public List<Account> getAllAccount() {

        List<Account> accounts = acoountService.getAllAccount();
        for (Account s : accounts) {
            slackClient.sendMessage("account_id:"+s.getId());
            slackClient.sendMessage("account_number:"+s.getAccountNumber());
            slackClient.sendMessage("account_blance:"+s.getBalance());
            slackClient.sendMessage("account_CraeteDate:"+s.getCreatedDate());
            slackClient.sendMessage("account_UpdateDate:"+s.getUpdatedDate());

        }
        return accounts;
    }
}
