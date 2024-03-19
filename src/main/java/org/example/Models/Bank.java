package org.example.Models;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.HashMap;

public class Bank {
    private static int nextIdentifier = 1;
    @Getter
    private final int bankId;
    private int interestRate;
    @Getter
    private final String bankName;
    private final HashMap<Integer, BankAccount> accounts = new HashMap<>();

    public Bank(String bankName) {
        bankId = nextIdentifier;
        nextIdentifier++;
        this.bankName = bankName;
    }

    public BankAccount getBankAccount(int id) {
        return accounts.get(id);
    }

    public void createBankAccounts(int ammount) {
        for(int i = 0; i <= ammount; i++) {
            createBankAccount();
        }
    }

    public BigDecimal sumTotalBalance () {
        BigDecimal total = BigDecimal.ZERO;
        accounts.values().forEach(x -> total.add(x.getBalance()));
        return total;
    }

    public void createBankAccount() {
        BankAccount ba = new BankAccount(this);
        System.out.println("Account: " + ba.getAccountId());
        accounts.put(ba.getAccountId(), ba);
    }
}
