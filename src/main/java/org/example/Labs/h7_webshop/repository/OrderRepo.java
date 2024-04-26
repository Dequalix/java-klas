package org.example.Labs.h7_webshop.repository;

import jakarta.persistence.EntityManager;
import org.example.Labs.h7_webshop.model.Customer;
import org.example.Labs.h7_webshop.model.Order;
import org.example.Labs.h7_webshop.model.Product;

import java.util.List;

public class OrderRepo extends Repository {

    public OrderRepo(EntityManager em) {
        super(em);
    }

    public Order createOrder(Customer c) {
        Order o = new Order();
        c.addOrderToList(o);
        o = (Order) performTransaction(em::merge, o);
        PerformTransActionConsumer(em::merge, o);
        return o;
    }

    public Order createOrder(List<Product> products, Customer c) {
        Order o = new Order(products);
        c.addOrderToList(o);
        o = (Order) performTransaction(em::merge, o);
        PerformTransActionConsumer(em::merge, o);
        return o;
    }

    public void addItemToOrder(Order o, Product p) {
        o.addProductToOrder(p);
        PerformTransActionConsumer(em::merge, o);
    }

    public String getTotalPrice(Order o) {
        return o.getTotalPrice().toString();
    }

    public void removeItemFromOrder(Order o, Product p) {
        o.removeProductFromOrder(p);
        PerformTransActionConsumer(em::merge, o);
    }
}
