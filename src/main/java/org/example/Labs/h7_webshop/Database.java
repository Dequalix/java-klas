package org.example.Labs.h7_webshop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.extern.slf4j.Slf4j;
import org.example.Labs.h7_webshop.model.Catalog;
import org.example.Labs.h7_webshop.model.Customer;
import org.example.Labs.h7_webshop.model.Order;
import org.example.Labs.h7_webshop.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class Database {

    public static void addCustomersToDatabase(EntityManager em) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            for (Customer customer : customers) {
                em.merge(customer);
            }
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            log.error(ex.getMessage(), ex);
        }
    }

    public static void addItemsAndCatalog(EntityManager em) {
        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();
            for (Catalog catalog : catalogs) {
                em.merge(catalog);
            }
            transaction.commit();
            transaction.begin();
            for (Product product : productList1) {
                product.setCatalog(
                        em.createQuery("select c from Catalog c where year(c.date) =:y", Catalog.class)
                            .setParameter("y", 2024)
                            .getSingleResult()
                );
                em.merge(product);
            }
            for (Product product : productList2) {
                product.setCatalog(
                        em.createQuery("select c from Catalog c where year(c.date) =:y", Catalog.class)
                                .setParameter("y", 2023)
                                .getSingleResult()
                );
                em.merge(product);
            }
            for (Product product : productList3) {
                product.setCatalog(
                        em.createQuery("select c from Catalog c where year(c.date) =:y", Catalog.class)
                                .setParameter("y", 2022)
                                .getSingleResult()
                );
                em.merge(product);
            }
            transaction.commit();
        } catch (Exception ex) {
            transaction.rollback();
            log.error(ex.getMessage(), ex);
        }
    }

    public static final List<Customer> customers = Arrays.asList(
            new Customer("Karel", "Apeldoorn", "Karelstraat 10", "7352KS", "karel@karel.nl"),
            new Customer("Peter", "Apeldoorn", "Peterstraat 15", "7332LA", "peter@peter.nl"),
            new Customer("Rick", "Apeldoorn", "Mortystraat 39", "7315OP", "Rick@rick.nl"),
            new Customer("Lisa", "Apeldoorn", "Lisastraat 225", "7312MS", "lisa@lisa.nl"),
            new Customer("Mike", "Apeldoorn", "Mikestraat 0", "7392UY", "mike@mike.nl"),
            new Customer("Maarten", "Apeldoorn", "Maartenseweg 10", "7333LL", "maarten@maarten.nl"),
            new Customer("Romy", "Apeldoorn", "Romyseweg 1", "7315KJ", "romy@romy.nl")
    );

    private static final List<Product> productList1 = Arrays.asList(
            new Product("item1", "10,50", "Good item"),
            new Product("item2", "52,10", "expensiv item"),
            new Product("item3", "12,10", ""),
            new Product("item4", "62,10", ""),
            new Product("item5", "5,20", ""),
            new Product("item6", "1,49", "")
    );
    private static final List<Product> productList2 = Arrays.asList(
            new Product("item7", "10,50", ""),
            new Product("item8", "52,10", ""),
            new Product("item9", "12,10", ""),
            new Product("item10", "62,10", ""),
            new Product("item11", "5,20", ""),
            new Product("item12", "1,49", "")
    );
    private static final List<Product> productList3 = Arrays.asList(
            new Product("item13", "10,50", ""),
            new Product("item14", "52,10", ""),
            new Product("item15", "12,10", ""),
            new Product("item16", "62,10", ""),
            new Product("item17", "5,20", ""),
            new Product("item18", "1,49", "")
    );

    public static final List<Product> products = Stream.of(productList1, productList2, productList3)
            .flatMap(List::stream)
            .collect(Collectors.toList());


    public static final List<Catalog> catalogs = List.of(
            new Catalog(2024, 1, 1, productList1),
            new Catalog(2023, 1, 1, productList2),
            new Catalog(2022, 1, 1, productList3)
    );

    public static final List<Order> orders = new ArrayList<>();
}
