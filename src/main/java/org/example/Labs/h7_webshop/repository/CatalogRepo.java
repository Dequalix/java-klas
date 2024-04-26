package org.example.Labs.h7_webshop.repository;

import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.example.Labs.h7_webshop.model.Catalog;
import org.example.Labs.h7_webshop.model.Product;

import java.util.List;

@Slf4j
public class CatalogRepo extends Repository {

    public CatalogRepo(EntityManager em) {
        super(em);
    }

    public Catalog createCatalog() {
        Catalog c = new Catalog();
        return (Catalog) performTransaction(em::merge, c);
    }

    public List<Catalog> findAllCatalogs() {
        return em.createQuery("select c from Catalog c", Catalog.class)
                .getResultList();
    }


    public List<Product> finCatalogByYear(int year) {
        return em.createQuery("select p from Product p join Catalog c on p.catalog.id = c.id where year(c.date) = :y order by p.id asc ", Product.class)
                .setParameter("y", year)
                .getResultList();
    }
}
