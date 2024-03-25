package org.example.Labs.h7_webshop.controller;

import org.example.Labs.h7_webshop.model.Catalog;
import org.example.Labs.h7_webshop.model.Product;
import org.example.Labs.h7_webshop.repository.CatalogRepo;
import org.example.Labs.h7_webshop.repository.ProductRepo;

import java.util.List;

public class CatalogController {
    CatalogRepo catalogRepo = new CatalogRepo();
    ProductRepo productRepo = new ProductRepo();
    public Catalog createCatalog(){
        return catalogRepo.createCatalog();
    }

    public void addItemToCatalog(String year, String productName) {
        Product p = productRepo.findByName(productName).stream().findFirst()
                // .get() -> get item
                // .map(x -> x) get item when available
                // .orElse() please learn english
                //
                .orElse(null);
        if (p == null){
            return;
        }
        // continue
        // TODO
    }

    public List<Catalog> findAllCatalogs() {
        return catalogRepo.findAllCatalogs();
    }
    public List<Product> findCatalogFromYear(int year) {
        return catalogRepo.finCatalogByYear(year);
    }
}
