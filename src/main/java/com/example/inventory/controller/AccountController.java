package com.example.inventory.controller;

import com.example.inventory.entity.AccountDetails;
import com.example.inventory.model.DebitCreditDetails;
import com.example.inventory.service.IAccountService;
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


    @DeleteMapping("/debit")
    public void debitAccount(@RequestBody DebitCreditDetails debitCreditDetails){
        accountService.debitAccount(debitCreditDetails);
    }

    @DeleteMapping("/credit")
    public void creditAccount(@RequestBody DebitCreditDetails debitCreditDetails){
        accountService.creditAccount(debitCreditDetails);
    }
}
