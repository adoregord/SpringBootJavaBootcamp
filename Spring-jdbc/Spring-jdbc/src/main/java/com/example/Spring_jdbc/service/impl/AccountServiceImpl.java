package com.example.Spring_jdbc.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Spring_jdbc.model.Account;
import com.example.Spring_jdbc.model.JoinAccount;
import com.example.Spring_jdbc.repository.AccountRepository;
import com.example.Spring_jdbc.service.AccountService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private AccountRepository repo;

    @Override
    public List<Account> listAll() {
        return repo.findAll();
    }

    @Override
    public Account get(Integer id) {

            return repo.findById(id);

    }

    @Override
    public Account save(Account account){
        repo.save(account);
        return account;
            // int updated =  repo.save(account);
            // if(updated > 0) {
            //     return repo.findById(account.getId());
            // } else {
            //     return null;
            // }

    }

    @Override
    public Account deposit(float amount, Integer id) {
        int updated = repo.deposit(amount, id);
        if(updated > 0) {
            return repo.findById(id);
        } else {
            return null;
        }
    }

    @Override
    public Account withdraw(float amount, Integer id) {
        int updated = repo.withdraw(amount, id);
        if(updated > 0) {
            return repo.findById(id);
        } else {
            return null;
        }
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    @Override
    public List<JoinAccount> listAccountJoin(){
        return repo.listAccountJoin();
    }

}
