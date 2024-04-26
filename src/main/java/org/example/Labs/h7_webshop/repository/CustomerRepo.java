package org.example.Labs.h7_webshop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.extern.slf4j.Slf4j;
import org.example.Labs.h7_webshop.model.Customer;

import java.util.List;

@Slf4j
public class CustomerRepo extends Repository {

    public CustomerRepo(EntityManager em) {
        super(em);
    }

    public Customer createCustomer(String name) {
        EntityTransaction transaction = em.getTransaction();
        Customer c = new Customer(name);
        return (Customer) performTransaction(em::merge, c);
    }

    public Customer createCustomer(String name, String residence, String address, String zipCode, String email) {
        Customer c = new Customer(name, residence, address, zipCode, email);
        return (Customer) performTransaction(em::merge, c);
    }

    public List<Customer> findBy(String name) {
        return em.createQuery("select c from Customer c where c.name = :n order by name asc", Customer.class)
                .setParameter("n", name)
                .getResultList()
                .stream()
                .toList();
    }

    public void save(Customer c) {
        PerformTransActionConsumer(em::merge, c);
    }


}
