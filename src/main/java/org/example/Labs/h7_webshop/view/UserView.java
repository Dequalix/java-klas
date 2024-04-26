package org.example.Labs.h7_webshop.view;

import jakarta.persistence.EntityManager;
import org.example.Labs.h7_webshop.model.Customer;

import static org.example.Labs.h7_webshop.Dependencies.*;

public class UserView implements View {
    public void start(EntityManager em) {

    }

    public void createUser() {
        System.out.flush();
        System.out.println("**********************");
        System.out.println("**    Create User   **");
        System.out.println("**********************");
        System.out.println("0) Go back");
        System.out.println("Enter your name");
        String name = in.nextLine();
        if (name.equals("0")) return;
        System.out.flush();
        System.out.println("**********************");
        System.out.println("**    Create User   **");
        System.out.println("**********************");
        System.out.println("0) Go back");
        System.out.println("Enter your place of residence");
        String residence = in.nextLine();
        if (residence.equals("0")) return;
        System.out.flush();
        System.out.println("**********************");
        System.out.println("**    Create User   **");
        System.out.println("**********************");
        System.out.println("0) Go back");
        System.out.println("Enter your zipcode(NL)");
        String zipCode = in.nextLine();
        if (zipCode.equals("0")) return;
        System.out.flush();
        System.out.println("**********************");
        System.out.println("**    Create User   **");
        System.out.println("**********************");
        System.out.println("0) Go back");
        System.out.println("Enter your street and number");
        String address = in.nextLine();
        if (address.equals("0")) return;
        System.out.flush();
        System.out.println("**********************");
        System.out.println("**    Create User   **");
        System.out.println("**********************");
        System.out.println("0) Go back");
        System.out.println("Enter your email");
        String email = in.nextLine();
        if (email.equals("0")) return;
        System.out.flush();
        customerController.createCustomer(name, residence, address, zipCode, email);
    }

    public void logIn() {
        System.out.flush();
        System.out.println("**********************");
        System.out.println("**       Log In     **");
        System.out.println("**********************");
        System.out.println("0) Go back");
        System.out.println("Enter your name");
        String name = in.nextLine();
        if (name.equals("0")) return;
        Customer c = customerController.findCustomer(name);
        if (c == null) {
            System.out.flush();
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

    public void viewOrders() {
        if (loggedInAs == null) logIn();
        customerController.orderList().stream().forEach(x -> {
            System.out.println(x.getId() + ": " + x.getOrderDate() + " - €" + x.calcTotalPrice());
        });
        String input = in.nextLine();

    }

    public void viewSingleOrder(int id) {

    }

    @Override
    public void start() {

    }
}
