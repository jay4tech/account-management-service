package com.example.inventory.service;

import com.example.inventory.entity.AccountDetails;
import com.example.inventory.model.TransactionEvent;

public interface IAccountService {
    AccountDetails getAccountDetails(Long id);

    AccountDetails createtAccountDetails(AccountDetails inventory);

    AccountDetails updateAccountDetails(AccountDetails inventory);

    void deleteAccountDetails(Long id);

    void debitCreditAccount(TransactionEvent transaction);
}
