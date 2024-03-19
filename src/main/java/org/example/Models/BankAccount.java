package org.example.Models;

import lombok.Getter;

import java.math.BigDecimal;

public class BankAccount {
    private static int nextAccountId;

    @Getter
    private final int accountId;
    private BigDecimal balance;

    public BankAccount() {
        accountId = nextAccountId;
        nextAccountId++;
    }

    public void addBalance(BigDecimal d) {
        balance = balance.add(d);
    }

    public void removeBalance(BigDecimal d) {
        if (hasBalance(d)) {
            balance = balance.subtract(d);
        }
    }

    public boolean hasBalance(BigDecimal d) {
        if (balance.compareTo(d) < 0) {
            return false;
        }
        return true;
    }
}
