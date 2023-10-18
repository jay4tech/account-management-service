package com.example.account.service;

import com.example.account.entity.AccountDetails;
import com.example.account.model.TransactionEvent;

public interface IAccountService {
    AccountDetails getAccountDetails(Long id);

    AccountDetails createtAccountDetails(AccountDetails inventory);

    AccountDetails updateAccountDetails(AccountDetails inventory);

    void deleteAccountDetails(Long id);

    void debitCreditAccount(TransactionEvent transaction);
}
