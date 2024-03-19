package org.example.Labs;

import org.example.Models.Bank;

import static org.example.Models.Bank.banks;

public class H7Bank {
    public static void main(String[] args) {

    }


    public void createBank(String name) {
        Bank b = new Bank(name);
        banks.put(b.getBankId(), b);
    }
}
