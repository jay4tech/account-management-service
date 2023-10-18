package com.example.inventory.service;

import com.example.inventory.entity.AccountDetails;
import com.example.inventory.model.DebitCreditDetails;
import com.example.inventory.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {

    @Autowired
    AccountRepository accountRepository;

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
        if(accountDetailsDb != null) {
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
    public void creditAccount(DebitCreditDetails debitCreditDetails) {
        AccountDetails accountDetailsDb = accountRepository.findById(debitCreditDetails.getAccountNo()).orElse(null);
        if(accountDetailsDb != null) {
            accountDetailsDb.setTotalAmount(accountDetailsDb.getTotalAmount() + debitCreditDetails.getAmount());
        } else {
            throw new AccountNotFoundException("Account Not found");
        }
    }

    @Override
    public void debitAccount(DebitCreditDetails debitCreditDetails) {
        AccountDetails accountDetailsDb = accountRepository.findById(debitCreditDetails.getAccountNo()).orElse(null);
        if(accountDetailsDb != null) {
            accountDetailsDb.setTotalAmount(accountDetailsDb.getTotalAmount() - debitCreditDetails.getAmount());
        } else {
            throw new AccountNotFoundException("Account Not found");
        }
    }
}
