package com.example.Spring_jdbc.model;

import lombok.Data;

@Data
public class JoinAccount {
    private String account_number;
    private String account_name;
    private Integer balance;
    private String bank_name;
}
