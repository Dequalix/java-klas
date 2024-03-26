package org.example.Labs.h7_webshop.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Order {
    @Getter
    @Setter
    private LocalDate orderDate;
    @Getter
    private int id;
    private static int nextId;
    @Getter
    private List<Product> items;
    @Getter
    @Setter
    private BigDecimal totalPrice;

    public Order() {
        orderDate = LocalDate.now();
        this.id = nextId;
        nextId++;
        items = new ArrayList<>();
        totalPrice = new BigDecimal("0.00");
    }

    public Order(List<Product> p) {
        orderDate = LocalDate.now();
        items = p;
        totalPrice = calcTotalPrice();
    }

    public BigDecimal calcTotalPrice() {
        return items.stream().map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void addProductToOrder(Product p) {
        this.setTotalPrice(this.calcTotalPrice());
        this.items.add(p);
    }

    public void removeProductFromOrder(Product p) {
        this.setTotalPrice(this.calcTotalPrice());
        this.items.remove(p);
    }

}
