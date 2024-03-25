package org.example.Labs.h7_webshop;

import org.example.Labs.h7_webshop.controller.*;
import org.example.Labs.h7_webshop.model.*;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Webshop {
    static Scanner in = new Scanner(System.in);
    static String input;
    static Customer loggedInAs = null;
    private static final String CLEAR_SCREEN = "\u001b[2J";
    static CustomerController customerController = new CustomerController();
    static CatalogController catalogController = new CatalogController();
    static OrderController orderController = new OrderController();
    static ProductController productController = new ProductController();

    public static void main(String[] args) {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            boolean peter = true;
            while (peter) {
                peter = mainMenu();
            }
        }
        catch (IOException | InterruptedException e) {
            System.out.println(e);
        }


    }

    public static boolean mainMenu() {
        if (loggedInAs == null) {
            System.out.println(CLEAR_SCREEN);
            System.out.println("**********************");
            System.out.println("**Webshop Main Menu***");
            System.out.println("**********************");
            System.out.println("1) Catalog");
//            System.out.println("2) Create Account");
            System.out.println("2) Log In");
            input = in.nextLine();
            switch (input) {
                case "1": {
                    catalog();
                    return true;
                }
                case "2": {
                    createUser();
                    return true;
                }
                case "3": {
                    logIn();
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
            System.out.println("1) Catalog");
            System.out.println("2) Log out ");
            input = in.nextLine();
            switch (input) {
                case "1": {
                    catalog();
                    return true;
                }
                case "2": {
                    loggedInAs = null;
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
        if (name.equals("0")) return;
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
        loggedInAs = c;
    }

    public static void createUser() {
        System.out.println(CLEAR_SCREEN);
        System.out.println("**********************");
        System.out.println("**    Create User   **");
        System.out.println("**********************");
        System.out.println("0) Go back");
        System.out.println("Enter your name");
        String name = in.nextLine();
        if (name.equals("0")) return;
        System.out.println(CLEAR_SCREEN);
        System.out.println("**********************");
        System.out.println("**    Create User   **");
        System.out.println("**********************");
        System.out.println("0) Go back");
        System.out.println("Enter your place of residence");
        String residence = in.nextLine();
        if (residence.equals("0")) return;
        System.out.println(CLEAR_SCREEN);
        System.out.println("**********************");
        System.out.println("**    Create User   **");
        System.out.println("**********************");
        System.out.println("0) Go back");
        System.out.println("Enter your zipcode(NL)");
        String zipCode = in.nextLine();
        if (zipCode.equals("0")) return;
        System.out.println(CLEAR_SCREEN);
        System.out.println("**********************");
        System.out.println("**    Create User   **");
        System.out.println("**********************");
        System.out.println("0) Go back");
        System.out.println("Enter your street and number");
        String address = in.nextLine();
        if (address.equals("0")) return;
        System.out.println(CLEAR_SCREEN);
        System.out.println("**********************");
        System.out.println("**    Create User   **");
        System.out.println("**********************");
        System.out.println("0) Go back");
        System.out.println("Enter your email");
        String email = in.nextLine();
        if (email.equals("0")) return;
        System.out.println(CLEAR_SCREEN);
        customerController.createCustomer(name, residence, address, zipCode,email);
    }

    public static void catalog() {
        System.out.println("**********************");
        System.out.println("**      Catalog     **");
        System.out.println("**********************");
        System.out.println("0) Go back");
        System.out.println("Enter the year of the Catalog you want to view");
        List<Catalog> catalogs = catalogController.findAllCatalogs();
        catalogs.stream().forEach(Catalog -> {
            System.out.println(Catalog.getYear().getYear());
        });
        String year = in.nextLine();

        System.out.println(CLEAR_SCREEN);
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
