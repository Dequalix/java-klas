package org.example.Labs.h7_webshop.view;

import org.example.Labs.h7_webshop.model.Catalog;
import org.example.Labs.h7_webshop.model.Product;

import java.util.List;

import static org.example.Labs.h7_webshop.Webshop.*;
import static org.example.Labs.h7_webshop.view.MainView.cartView;

public class CatalogView implements View {


    public void start() {
        while (true) {
            System.out.flush();
            System.out.println("**********************");
            System.out.println("**      Catalog     **");
            System.out.println("**********************");
            System.out.println("0) Go back");
            System.out.println("Enter the year of the Catalog you want to view");
            List<Catalog> catalogs = catalogController.findAllCatalogs();
            catalogs.forEach(Catalog -> {
                System.out.println(Catalog.getDate().getYear());
            });
            String year = in.nextLine();
            if (year.equals("0")) return;
            if (!year.isEmpty()) {
                try {
                    this.catalogItemsByYear(Integer.parseInt(year));
                } catch (NumberFormatException e) {
                    System.out.println("Wrong input, expect a number.");
                    in.nextLine();
                }
            }
        }

    }

    public void catalogItemsByYear(int year) {
        while (true) {
            System.out.flush();
            System.out.println("**********************");
            System.out.println("**      Catalog     **");
            System.out.println("**********************");
            List<Product> products = catalogController.findCatalogFromYear(year);
            if (products.isEmpty()) {
                System.out.println("No items found for this year");
                in.nextLine();
                return;
            }
            System.out.println("Select a product by id.");
            System.out.println("0) Go Back");
            products.forEach(Product -> System.out.println(Product.getId() + ": " + Product.getName() + " - €" + Product.getPrice()));
            String input = in.nextLine();
            if (input.equals("0")) return;
            if (!input.isEmpty()) {
                try {
                    product(Integer.parseInt(input));
                } catch (NumberFormatException e) {
                    System.out.println("Wrong input, expect a number.");
                }
            }
        }
    }

    public static void product(int id) {
        while (true) {
            Product p = productController.findProductById(id);
            System.out.println(p.getName() + ": " + p.getDescription());
            System.out.println("Price: €" + p.getPrice());
            System.out.println("1) Add to cart");
            System.out.println("2) Show cart");
            System.out.println("0) Go back");
            String input = in.nextLine();
            switch (input) {
                case "0": {
                    return;
                }
                case "1": {
                    cart.add(p);
                    System.out.println(p.getName() + " added to cart");
                    break;
                }
                case "2": {
                    cartView.start();
                    break;
                }
            }
        }
    }
}
