package org.example.Labs.h7_webshop.view;


import static org.example.Labs.h7_webshop.Dependencies.in;
import static org.example.Labs.h7_webshop.Dependencies.loggedInAs;

public class MainView implements View {
    private String input;
    public static UserView userView = new UserView();
    public static CatalogView catalogView = new CatalogView();
    public static CartView cartView = new CartView();

    public void start() {
        boolean peter = true;
        while (peter) {
            peter = menu();
        }

    }

    private boolean menu() {
        if (loggedInAs == null) {
            System.out.flush();
            System.out.println("**********************");
            System.out.println("**Webshop Main Menu***");
            System.out.println("**********************");
            System.out.println("1) Catalog");
//            System.out.println("2) Create Account");
            System.out.println("2) Log In");
            System.out.println("3) Show Cart");
            input = in.nextLine();
            switch (input) {
                case "1": {
                    catalogView.start();
                    return true;
                }
                case "2": {
                    userView.logIn();
                    return true;
                }
                case "3": {
                    cartView.start();
                    return true;
                }
//                case "3": {
//                    userView.createUser();
//                    return true;
//                }
                case "exit": {
                    return false;
                }

            }
            return true;
        } else {
            System.out.flush();
            System.out.println("**********************");
            System.out.println("**Webshop Main Menu***");
            System.out.println("**********************");
            System.out.println("1) Catalog");
            System.out.println("2) Log out ");
            System.out.println("3) Show Cart");
            input = in.nextLine();
            switch (input) {
                case "1": {
                    catalogView.start();
                    return true;
                }
                case "2": {
                    loggedInAs = null;
                    return true;
                }
                case "3": {
                    cartView.start();
                    return true;
                }
                case "exit": {
                    return false;
                }
            }
            return true;
        }
    }
}
