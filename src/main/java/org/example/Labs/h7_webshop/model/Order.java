package org.example.Labs.h7_webshop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order {
    @Getter
    @Setter
    private LocalDate orderDate;
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Getter
    @OneToMany(mappedBy = "order")
    private List<Product> items;
    @Getter
    @Setter
    private BigDecimal totalPrice;
    @ManyToOne
    private Customer customer;

    public Order() {
        orderDate = LocalDate.now();
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
