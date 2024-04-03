package org.example.Labs.h7.Models;

import lombok.Getter;

import java.math.BigDecimal;

public class BankAccount {
    private static int nextAccountId;
    private final Bank bank;
    private final BigDecimal DEFAUlT_VALUE = BigDecimal.valueOf(0.00);

    @Getter
    private final int accountId;
    @Getter
    private BigDecimal balance;

    public BankAccount(Bank b) {
        this.bank = b;
        accountId = nextAccountId;
        balance = DEFAUlT_VALUE;
        nextAccountId++;
    }

    public boolean addBalance(BigDecimal d) {
        balance = balance.add(d);
        return true;
    }

    public boolean removeBalance(BigDecimal d) {
        if (hasBalance(d)) {
            balance = balance.subtract(d);
            return true;
        }
        return false;
    }

    private boolean hasBalance(BigDecimal d) {
        return balance.compareTo(d) >= 0;
    }
}
