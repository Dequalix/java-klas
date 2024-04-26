package org.example.Labs.h7_webshop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import org.example.Labs.h7_webshop.controller.CatalogController;
import org.example.Labs.h7_webshop.controller.CustomerController;
import org.example.Labs.h7_webshop.controller.OrderController;
import org.example.Labs.h7_webshop.controller.ProductController;
import org.example.Labs.h7_webshop.model.Catalog;
import org.example.Labs.h7_webshop.model.Customer;
import org.example.Labs.h7_webshop.model.Product;
import org.example.Labs.h7_webshop.repository.CatalogRepo;
import org.example.Labs.h7_webshop.repository.CustomerRepo;
import org.example.Labs.h7_webshop.repository.OrderRepo;
import org.example.Labs.h7_webshop.repository.ProductRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dependencies {
    public static Scanner in = new Scanner(System.in);
    public static Customer loggedInAs = null;
    static final EntityManager em = Persistence.createEntityManagerFactory("MySQL").createEntityManager();
    private static CustomerRepo customerRepo = new CustomerRepo(em);
    private static OrderRepo orderRepo = new OrderRepo(em);
    private static ProductRepo productRepo = new ProductRepo(em);
    private static CatalogRepo catalogRepo = new CatalogRepo(em);
    public static CustomerController customerController = new CustomerController(em, customerRepo);
    public static OrderController orderController = new OrderController(em, orderRepo, customerRepo, productRepo);
    public static ProductController productController = new ProductController(em, productRepo);
    public static CatalogController catalogController = new CatalogController(em, catalogRepo, productRepo);

    public static List<Product> cart = new ArrayList<>();
}
