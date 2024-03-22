package org.example.Labs.H7.Models;

import lombok.Getter;
import lombok.Setter;
import org.example.Labs.H7.Manager.BankAccountManager;

import java.math.BigDecimal;

public class Bank {
    private static int nextIdentifier = 1;
    @Getter
    private final int bankId;
    private int interestRate;
    @Getter
    private final String bankName;
    @Setter
    private BankAccountManager accountManager;


    public Bank(String bankName) {
        accountManager = new BankAccountManager();
        bankId = nextIdentifier;
        nextIdentifier++;
        this.bankName = bankName;
    }

    public BankAccount getBankAccount(int id) {
        return accountManager.getBankAccount(id);
    }

    public void createBankAccounts(int amount) {
        for (int i = 0; i <= amount; i++) {
            createBankAccount();
        }
    }

    public static boolean sendMoneyFromTo(BankAccount a, BankAccount b, BigDecimal amount) {
        if (a.removeBalance(amount)) {
            b.addBalance(amount);
            return true;
        }
        return false;
    }

    public BigDecimal sumTotalBalance() {
        return accountManager.sumTotalBalance();
    }

    public void createBankAccount() {
        accountManager.createBankAccount(this);
    }
}
