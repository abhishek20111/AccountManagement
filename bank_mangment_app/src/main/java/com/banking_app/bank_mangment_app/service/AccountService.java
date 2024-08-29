package com.banking_app.bank_mangment_app.service;

import com.banking_app.bank_mangment_app.model.Account;

import java.util.List;

public interface AccountService {
    public Account createAccount(Account account);
    public Account getAccountDetialsByAccountNumber(Long accountNumber);
    public List<Account> getAllAccountDetials();
    public Account depositAmount(Long accountNumber, Double amout);
    public Account withdrawAmout(Long accountNumber, Double amout);
    public void closeAccount(Long accountNumber);
}
