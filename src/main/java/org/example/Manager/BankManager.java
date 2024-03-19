package org.example.Manager;

import org.example.Models.Bank;
import org.example.Models.BankAccount;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class BankManager {
    private static Map<String, Bank> banks = new HashMap<>();

    public static Bank addBank(String name) {
        Bank b = new Bank(name);
        banks.put(b.getBankName(), b);
        return b;
    }

    public static Bank getBank(String name) {
        return banks.get(name);
    }

    public static BankAccount getBackAccount(String bankName, int accountID) {
        var bank = banks.get(bankName);
        return bank != null ? bank.getBankAccount(accountID) : null;
    }

    public static boolean sendMoneyFromTo(BankAccount a, BankAccount b, BigDecimal ammount) {
        if (a.removeBalance(ammount)) {
            b.addBalance(ammount);
            return true;
        }
        return false;
    }
}
