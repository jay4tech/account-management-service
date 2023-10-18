package com.example.account.controller;

import com.example.account.entity.AccountDetails;
import com.example.account.model.TransactionEvent;
import com.example.account.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("accounts")
public class AccountController {

    @Autowired
    IAccountService accountService;

    @GetMapping("/{id}")
    public AccountDetails getAccountDetails(@PathVariable Long id){
        return accountService.getAccountDetails(id);
    }

    @PostMapping("/createAccount")
    public AccountDetails createAccountDetails(@RequestBody AccountDetails accountDetails){
        return accountService.createtAccountDetails(accountDetails);
    }
    @PutMapping("/updateAccount")
    public AccountDetails updateAccountDetails(@RequestBody AccountDetails accountDetails){
        return accountService.updateAccountDetails(accountDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteAccountDetails(@PathVariable Long id){
         accountService.deleteAccountDetails(id);
    }


    @GetMapping("/debit")
    public void debitAccount(@RequestBody TransactionEvent transaction){
        accountService.debitCreditAccount(transaction);
    }

    @GetMapping("/credit")
    public void creditAccount(@RequestBody TransactionEvent transaction){
        accountService.debitCreditAccount(transaction);
    }
}
