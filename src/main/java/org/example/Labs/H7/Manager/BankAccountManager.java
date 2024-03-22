package org.example.Labs.H7.Manager;

import org.example.Labs.H7.Models.Bank;
import org.example.Labs.H7.Models.BankAccount;

import java.math.BigDecimal;
import java.util.HashMap;

public class BankAccountManager {
    private final HashMap<Integer, BankAccount> accounts = new HashMap<>();

    public BankAccountManager() {

    }

    public BankAccount getBankAccount(int id) {
        return accounts.get(id);
    }

    public BankAccount createBankAccount(Bank bank) {
        BankAccount ba = new BankAccount(bank);
        System.out.println("Account: " + ba.getAccountId());
        accounts.put(ba.getAccountId(), ba);
        return ba;
    }

    public BigDecimal sumTotalBalance() {
        BigDecimal total = BigDecimal.ZERO;
        accounts.values().forEach(x -> total.add(x.getBalance()));
        return total;
    }
}
