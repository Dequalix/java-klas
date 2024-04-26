package org.example.Labs.h7_webshop;

import jakarta.persistence.EntityManager;
import org.example.Labs.h7_webshop.view.MainView;

import static org.example.Labs.h7_webshop.Database.addCustomersToDatabase;
import static org.example.Labs.h7_webshop.Database.addItemsAndCatalog;
import static org.example.Labs.h7_webshop.Dependencies.em;

public class Webshop {

    static MainView mainMenu = new MainView();


    public static void main(String[] args) {
//        addCustomersToDatabase(em);
//        addItemsAndCatalog(em);
        mainMenu.start();
    }

}
