package com.example.Spring_jdbc.repository;

import java.util.List;

import com.example.Spring_jdbc.model.Account;
import com.example.Spring_jdbc.model.JoinAccount;

public interface AccountRepository {
    int save(Account account);
    int update(Account account);
    Account findById(Integer id);
    List<Account> findAll();
    boolean existsById(Integer id);
    int deleteById(Integer id);
    int deposit(float amount, Integer id);
    int withdraw(float amount, Integer id);
    List<JoinAccount> listAccountJoin();
    void deleteAll();
}