package org.example.Labs.h7;

import org.example.Labs.h7.Manager.BankManager;

import java.util.List;
import java.util.Scanner;


public class Bank {
    static Scanner scanner = new Scanner(System.in);
    static String input;

    public static void main(String[] args) {
        setup();
        System.out.println("...");
        input = scanner.nextLine();
    }

    public static void setup() {
        BankManager bankManager = BankManager.instance;
        List.of(bankManager.addBank("ABN"),
                        bankManager.addBank("Rabobank"),
                        bankManager.addBank("SNS"),
                        bankManager.addBank("DSB"))
                .forEach(x -> {
                    x.createBankAccounts(10);
                    System.out.println("Bank: " + x.getBankName());
                });
    }
}
