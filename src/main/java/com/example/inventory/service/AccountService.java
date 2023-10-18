package com.example.inventory.service;

import com.example.inventory.entity.AccountDetails;
import com.example.inventory.exception.AccountNotFoundException;
import com.example.inventory.model.TransactionEvent;
import com.example.inventory.model.TransactionType;
import com.example.inventory.repository.AccountRepository;
import com.example.inventory.utils.MessageSender;
import com.example.inventory.utils.UtilityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    MessageSender messageSender;

    @Override
    public AccountDetails getAccountDetails(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public AccountDetails createtAccountDetails(AccountDetails accountDetails) {
        return accountRepository.save(accountDetails);
    }

    @Override
    public AccountDetails updateAccountDetails(AccountDetails accountDetails) {
        AccountDetails accountDetailsDb = accountRepository.findById(accountDetails.getId()).orElse(null);
        if (accountDetailsDb != null) {
            accountDetails.setId(accountDetailsDb.getId());
            return accountRepository.save(accountDetails);
        }
        return accountDetails;
    }

    @Override
    public void deleteAccountDetails(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public void debitCreditAccount(TransactionEvent transaction) {
        AccountDetails accountDetailsDb = accountRepository.findById(transaction.getAccountNo()).orElse(null);
        if (accountDetailsDb != null) {
            if (transaction.getType().equals(TransactionType.CREDIT))
                accountDetailsDb.setTotalAmount(accountDetailsDb.getTotalAmount() + transaction.getAmount());
            else if (transaction.getType().equals(TransactionType.DEBIT))
            accountDetailsDb.setTotalAmount(accountDetailsDb.getTotalAmount() - transaction.getAmount());
            messageSender.sendDebitCreditDetails(UtilityMapper.getJsonString(accountDetailsDb));
        } else {
            throw new AccountNotFoundException("Account Not found");
        }
    }
}
