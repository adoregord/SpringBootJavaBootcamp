package com.example.Spring_jdbc.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.Spring_jdbc.model.Account;
import com.example.Spring_jdbc.model.JoinAccount;
import com.example.Spring_jdbc.repository.AccountRepository;

@Repository
public class JdbcAccountRepository implements AccountRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Account account) {
        return jdbcTemplate.update("INSERT INTO accounts (account_number, balance) VALUES(?,?)",
                new Object[] { account.getAccountNumber(), account.getBalance() });
    }

    @Override
    public int update(Account account) {
        return jdbcTemplate.update("UPDATE accounts SET account_number=?, balance=? WHERE id=?",
                new Object[] { account.getAccountNumber(), account.getBalance(), account.getId() });
    }

    @Override
    public Account findById(Integer id) {
        Account account = jdbcTemplate.queryForObject("SELECT * FROM accounts WHERE id=?",
                BeanPropertyRowMapper.newInstance(Account.class), id);
        return account;
    }

    @Override
    public List<Account> findAll() {
        return jdbcTemplate.query("SELECT * from accounts", BeanPropertyRowMapper.newInstance(Account.class));
    }

    @Override
    public boolean existsById(Integer id) {
        Integer count = this.jdbcTemplate.queryForObject("select count(*) from accounts WHERE id=?", Integer.class, id);
        if(count > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int deleteById(Integer id) {
        return jdbcTemplate.update("DELETE FROM accounts WHERE id=?", id);
    }

    @Override
    public int deposit(float amount, Integer id) {
        return jdbcTemplate.update("UPDATE accounts SET balance=balance + ? WHERE id=?",
                new Object[] { amount, id });
    }

    @Override
    public int withdraw(float amount, Integer id) {
        return jdbcTemplate.update("UPDATE accounts SET balance=balance - ? WHERE id=?",
                new Object[] { amount, id });
    }

    @Override
    public List<JoinAccount> listAccountJoin(){
        return jdbcTemplate.query("""
                                  select a.account_number , ai.account_name, a.balance, bi.bank_name 
                                  from accounts a
                                  join account_info ai ON a.id = ai.accounts_id
                                  join bank_info bi ON a.id = bi.accounts_id""" //
        //
        , 
        BeanPropertyRowMapper.newInstance(JoinAccount.class));
    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }

}