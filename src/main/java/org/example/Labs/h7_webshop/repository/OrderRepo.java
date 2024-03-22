package org.example.Labs.h7_webshop.repository;

import org.example.Labs.h7_webshop.Database;
import org.example.Labs.h7_webshop.model.Customer;
import org.example.Labs.h7_webshop.model.Order;
import org.example.Labs.h7_webshop.model.Product;

import java.util.List;

public class OrderRepo {
    public Order createOrder(Customer c) {
        Order o = new Order();
        int i = Database.customers.indexOf(c);
        c.addOrderToList(o);
        Database.orders.add(o);
        Database.customers.set(i, c);
        return o;
    }

    public Order createOrder(List<Product> products, Customer c) {
        Order o = new Order();
        int i = Database.customers.indexOf(c);
        c.addOrderToList(o);
        Database.orders.add(o);
        Database.customers.set(i, c);
        return o;
    }

    public void addItemToOrder(Order o, Product p) {
        int i = Database.orders.indexOf(o);
        o.addProductToOrder(p);
        Database.orders.set(i, o);
    }

    public String getTotalPrice(Order o) {
        return o.getTotalPrice().toString();
    }

    public void removeItemFromOrder(Order o, Product p) {
        int i = Database.orders.indexOf(o);
        o.removeProductFromOrder(p);
        Database.orders.set(i, o);
    }
}
