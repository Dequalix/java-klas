package org.example.Models;

import lombok.Getter;

import java.math.BigDecimal;

public class BankAccount {
    private static int nextAccountId;
    private final Bank bank;

    @Getter
    private final int accountId;
    @Getter
    private BigDecimal balance;

    public BankAccount(Bank b) {
        this.bank = b;
        accountId = nextAccountId;
        nextAccountId++;
    }

    public void addBalance(BigDecimal d) {
        balance = balance.add(d);
    }

    public boolean removeBalance(BigDecimal d) {
        if (hasBalance(d)) {
            balance = balance.subtract(d);
            return true;
        }
        return false;
    }

    public boolean hasBalance(BigDecimal d) {
        return balance.compareTo(d) >= 0;
    }
}
