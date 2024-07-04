package com.example.Spring_jdbc.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Account {

    private Integer id;
    private String accountNumber;
    private float balance;

    public Account(String accountNumber, float balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}