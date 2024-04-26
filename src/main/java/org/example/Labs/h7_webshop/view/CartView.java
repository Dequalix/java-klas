package org.example.Labs.h7_webshop.view;

import org.example.Labs.h7_webshop.model.Product;

import java.math.BigDecimal;

import static org.example.Labs.h7_webshop.Dependencies.*;
import static org.example.Labs.h7_webshop.view.MainView.userView;


public class CartView implements View {
    public void start() {
        System.out.println("**********************");
        System.out.println("**       Cart       **");
        System.out.println("**********************");
        System.out.println("1) Go to checkout");
        System.out.println("0) Go back");
        cart.forEach(x -> {
            System.out.println(x.getName() + ": €" + x.getPrice());
        });
        System.out.println("Total Price: €" + cart.stream().map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add));
        String input = in.nextLine();
        if (input.equals("1")) {
            if (loggedInAs == null) {
                System.out.println("You need to login first.");
                System.out.println("press enter to continue");
                in.nextLine();
                userView.logIn();
            }
            orderController.createOrder(cart, loggedInAs);
        }
    }
}
