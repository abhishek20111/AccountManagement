package com.banking_app.bank_mangment_app.service;

import com.banking_app.bank_mangment_app.model.Account;
import com.banking_app.bank_mangment_app.repositiery.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImplement implements AccountService {

    @Autowired
    AccountRepository repo;


    @Override
    public Account createAccount(Account account) {
        Account accountSaved = repo.save(account);
        return accountSaved;
    }

    @Override
    public Account getAccountDetialsByAccountNumber(Long accountNumber) {
        Optional<Account> account = repo.findById(accountNumber);
        System.out.println(account);
        if(account.isEmpty()){
            throw new RuntimeException("Account is not Present");
        }
        Account account_fount = account.get();
        return account_fount;
    }

    @Override
    public List<Account> getAllAccountDetials() {
        List<Account> ll = repo.findAll();
        return ll;
    }

    @Override
    public Account depositAmount(Long accountNumber, Double amount) {
        accountNumber = accountNumber != null ? accountNumber : 2;
        System.out.println("Depositing amount for account ID: {}"+ accountNumber);

        if (accountNumber == null) {
            throw new IllegalArgumentException("Account ID must not be null");
        }
        Optional<Account> account = repo.findById(accountNumber);
        if(account.isEmpty())throw new RuntimeException("Account is not present");
        Account accountPresent = account.get();
        Double totalbalance = accountPresent.getAccount_balance() + amount;
        repo.save(accountPresent);
        return accountPresent;
    }

    @Override
    public Account withdrawAmout(Long accountNumber, Double amount) {
        Optional<Account> account = repo.findById(accountNumber);
        if(account.isEmpty())throw new RuntimeException("Account is not present");
        Account accountPresent = account.get();
        Double totalbalance = accountPresent.getAccount_balance() - amount;
        repo.save(accountPresent);
        return accountPresent;
    }

    @Override
    public void closeAccount(Long accountNumber) {

    }
}
