package uqtr;

import uqtr.database.Database;
import uqtr.menus.MainMenu;
import uqtr.menus.ProductMenu;
import uqtr.models.product.Product;
import uqtr.models.product.ProductUnit;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        addMockData();
        new MainMenu().start();
    }

    //Pour des fins de test, serait retiré en production
    private static void addMockData() {
        var repo = Database.getInstance().getProductRepository();
        repo.add(new Product("Banane", 1.99, true));
        var banane = repo.find("banane");
        banane.getStock().push(new ProductUnit(new Date(System.currentTimeMillis())));
        banane.getStock().push(new ProductUnit(new Date(System.currentTimeMillis())));
        banane.getStock().push(new ProductUnit(new Date(System.currentTimeMillis())));
        banane.getStock().push(new ProductUnit(new Date(System.currentTimeMillis())));
        banane.getStock().push(new ProductUnit(new Date(System.currentTimeMillis())));
        banane.getStock().push(new ProductUnit(new Date(System.currentTimeMillis())));
        banane.getStock().push(new ProductUnit(new Date(System.currentTimeMillis())));
        banane.getStock().push(new ProductUnit(new Date(System.currentTimeMillis())));
        banane.getStock().push(new ProductUnit(new Date(System.currentTimeMillis())));
        repo.add(new Product("Alcool à friction", 2.49, false));
        var alcool = repo.find("Alcool à friction");
        alcool.getStock().push(new ProductUnit(new Date(System.currentTimeMillis())));
        alcool.getStock().push(new ProductUnit(new Date(System.currentTimeMillis())));
        alcool.getStock().push(new ProductUnit(new Date(System.currentTimeMillis())));
        alcool.getStock().push(new ProductUnit(new Date(System.currentTimeMillis())));
        alcool.getStock().push(new ProductUnit(new Date(System.currentTimeMillis())));
        alcool.getStock().push(new ProductUnit(new Date(System.currentTimeMillis())));
        alcool.getStock().push(new ProductUnit(new Date(System.currentTimeMillis())));
    }
}