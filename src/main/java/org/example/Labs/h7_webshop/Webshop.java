package org.example.Labs.h7_webshop;

import org.example.Labs.h7_webshop.controller.CustomerController;
import org.example.Labs.h7_webshop.model.Customer;

import java.util.Scanner;

public class Webshop {
    static Scanner in = new Scanner(System.in);
    static String input;
    static Boolean isLoggedIn = false;
    private static final String CLEAR_SCREEN = "\u001b[2J";
    static CustomerController customerController = new CustomerController();

    public static void main(String[] args) {
        boolean peter = true;
        while (peter) {
            peter = mainMenu();
        }

    }

    public static boolean mainMenu() {
        if (!isLoggedIn) {
            System.out.println(CLEAR_SCREEN);
            System.out.println("**********************");
            System.out.println("**Webshop Main Menu***");
            System.out.println("**********************");
            System.out.println("1) Log in");
            System.out.println("2) Aanmaken gebruiker");
            System.out.println("3) Catalog Bekijken");
            input = in.nextLine();
            switch (input) {
                case "1": {
                    logIn();
                    return true;
                }
                case "2": {
                    return true;
                }
                case "3": {
                    return true;
                }
                case "exit": {
                    return false;
                }

            }
            return true;
        } else {
            System.out.println(CLEAR_SCREEN);
            System.out.println("**********************");
            System.out.println("**Webshop Main Menu***");
            System.out.println("**********************");
            System.out.println("1) Check out Catalog");
            System.out.println("2) Log out ");
            input = in.nextLine();
            switch (input) {
                case "1": {
                    return true;
                }
                case "2": {
                    isLoggedIn = false;
                    return true;
                }
                case "exit": {
                    return false;
                }
            }
            return false;
        }
    }


    public static void logIn() {
        System.out.println(CLEAR_SCREEN);
        System.out.println("**********************");
        System.out.println("**       Log In     **");
        System.out.println("**********************");
        System.out.println("0) Go back");
        System.out.println("Enter your name");
        String name = in.nextLine();
        if (name.equals("0")) {
            return;
        }
        Customer c = customerController.findCustomer(name);
        if (c == null) {
            System.out.println(CLEAR_SCREEN);
            System.out.println("**********************");
            System.out.println("**       Log In     **");
            System.out.println("**********************");
            System.out.println("Name doesnt exist in database, try again.");
            System.out.println("Press Enter to return");
            in.nextLine();
            return;
        }
        isLoggedIn = true;
    }


}

/*

**********************
**Webshop Main Menu***
**********************
//(als niet ingelogd)
1) Log in
2) Aanmaken gebruiker
3) Catalog Bekijken

**********************
**Webshop Main Menu***
**********************
(als ingelogd)

1) Catalog Bekijken
2) Uitloggen


**********************
**Kies Jaar Catalog***
**********************

**********************
**Log in gebruiker****
**********************
- Naam (gebruiker) invoeren

**********************
**Aanmaken gebruiker**
**********************
- Naam nieuwe gebruiker invoeren
- Woonplaats
- Address
- Postcode
- Email




 */
