package com.example.Spring_jdbc.service;

import java.util.List;

import com.example.Spring_jdbc.model.Account;
import com.example.Spring_jdbc.model.JoinAccount;

public interface AccountService {
    List<Account> listAll();

    Account get(Integer id);

    Account save(Account account);

    Account deposit(float amount, Integer id);

    Account withdraw(float amount, Integer id);

    void delete(Integer id);

    List<JoinAccount> listAccountJoin();
}

