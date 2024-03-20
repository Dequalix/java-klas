package org.example.Manager;

import org.example.Models.Bank;
import org.example.Models.BankAccount;

import java.util.HashMap;
import java.util.Map;

public class BankManager {
    private static Map<String, Bank> banks = new HashMap<>();

    public static BankManager instance = new BankManager();

    private BankManager() {

    }


    public Bank addBank(String name) {
        Bank b = new Bank(name);
        banks.put(b.getBankName(), b);
        return b;
    }

    public Bank getBank(String name) {
        return banks.get(name);
    }

    public BankAccount getBackAccount(String bankName, int accountID) {
        var bank = banks.get(bankName);
        return bank != null ? bank.getBankAccount(accountID) : null;
    }

}
