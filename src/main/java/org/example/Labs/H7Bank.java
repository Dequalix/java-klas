package org.example.Labs;

import org.example.Manager.BankManager;
import org.example.Models.Bank;

import java.util.List;
import java.util.Scanner;


public class H7Bank {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        setup();
        System.out.println("...");
    }

    public static void setup() {
        List.of(BankManager.addBank("ABN"),
                BankManager.addBank("Rabobank"),
                BankManager.addBank("SNS"),
                BankManager.addBank("DSB"))
            .forEach(x -> {
                x.createBankAccounts(10);
                System.out.println("Bank: " + x.getBankName());
            });
    }
}
