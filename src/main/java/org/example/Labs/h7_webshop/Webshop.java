package org.example.Labs.h7_webshop;

import org.example.Labs.h7_webshop.controller.CatalogController;
import org.example.Labs.h7_webshop.controller.CustomerController;
import org.example.Labs.h7_webshop.controller.OrderController;
import org.example.Labs.h7_webshop.controller.ProductController;
import org.example.Labs.h7_webshop.model.Customer;
import org.example.Labs.h7_webshop.model.Product;
import org.example.Labs.h7_webshop.view.MainView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Webshop {
    public static Scanner in = new Scanner(System.in);
    public static Customer loggedInAs = null;
    public static CustomerController customerController = new CustomerController();
    public static OrderController orderController = new OrderController();
    public static ProductController productController = new ProductController();
    public static CatalogController catalogController = new CatalogController();
    public static List<Product> cart = new ArrayList<>();
    static MainView mainMenu = new MainView();


    public static void main(String[] args) {
        mainMenu.start();
    }

}
