package com.banking_app.bank_mangment_app.repositiery;

import com.banking_app.bank_mangment_app.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
