package com.banking_app.bank_mangment_app.controller;

import com.banking_app.bank_mangment_app.model.Account;
import com.banking_app.bank_mangment_app.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService service;

    @PostMapping("/create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account){
        Account createdAccount = service.createAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAccount);
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<Account> getAccountByAccountNumber(@PathVariable Long accountNumber){
        Account account =  service.getAccountDetialsByAccountNumber(accountNumber);
        return  ResponseEntity.status(201).body(account);
    }

    @GetMapping("/getallaccount")
    public List<Account> getAllAccountDetails(){
        List<Account> getAllAccountDetails = service.getAllAccountDetials();
        return getAllAccountDetails;
    }

    @PutMapping("/deposit/{accountNumber}/{amount}")
    public Account depositeAccount(@PathVariable Long accountNumber,@PathVariable Double amount){
        System.out.println("accountNumber"+accountNumber+" "+amount);
        Account account = service.depositAmount(accountNumber, amount);
        return account;
    }

    @PutMapping("/withdraw/{accountNumber}/{amount}")
    public Account withdrawamount(@PathVariable Long accountNumber,@PathVariable Double amount){
        System.out.println("accountNumber"+accountNumber+" "+amount);
        Account account = service.withdrawAmout(accountNumber, amount);
        return account;
    }
}
