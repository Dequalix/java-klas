package org.example.Models;

import lombok.Getter;

import java.util.HashMap;

public class Bank {
    private static int nextIdentifier = 1;
    public static HashMap banks;
    @Getter
    private int bankId;
    private int interestRate;
    private String bankName;
    private HashMap accounts = new HashMap<>();

    public Bank(String bankName) {
        bankId = nextIdentifier;
        nextIdentifier++;
        this.bankName = bankName;
    }

    public void createBankAccount() {
        BankAccount ba = new BankAccount();
        accounts.put(ba.getAccountId(), ba);
    }

}
