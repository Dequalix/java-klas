package org.example.Models;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Bank {
    private static int nextIdentifier = 1;
    @Getter
    private int bankId;
    private int interestRate;
    @Getter
    private String bankName;
    private HashMap<Integer, BankAccount> accounts = new HashMap<>();

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
        accounts.values().forEach(x -> {
            total.add(x.getBalance());
        });
        return total;
    }

    public void createBankAccount() {
        BankAccount ba = new BankAccount(this);
        accounts.put(ba.getAccountId(), ba);
    }
}
