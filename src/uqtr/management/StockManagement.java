package uqtr.management;

import uqtr.database.Database;
import uqtr.database.ProductRepository;
import uqtr.helpers.DateGenerator;
import uqtr.helpers.Terminal;
import uqtr.models.product.Product;
import uqtr.models.product.ProductUnit;
import uqtr.stock.StockQueue;

import java.util.Date;

public class StockManagement {
    private final ProductRepository products;

    public StockManagement() {
        products = Database.getInstance().getProductRepository();
    }

    public void add() {
        System.out.print("Entrer le nom du produit pour lequel ajouter du stock: ");
        String name = Terminal.readStringInput();
        Product productToAddStock = products.find(name);
        if (productToAddStock != null) {
            Date expirationDate = null;
            if (productToAddStock.getStock() instanceof StockQueue) {
                //Devrait être entré par l'usager, mais jugé non pertinent pour le TP, rentrer une date dans un CLI n'est pas super.
                expirationDate = DateGenerator.getRandomDateInNextYear();
            }
            var unit = new ProductUnit(expirationDate);
            productToAddStock.getStock().push(unit);
            System.out.println("Ajouté au stock!");
        } else {
            System.out.println("Erreur: Produit non trouvé.");
        }
    }

    public void remove() {
        System.out.print("Entrer le nom du produit pour lequel retirer du stock: ");
        String name = Terminal.readStringInput();
        Product productToRemoveStock = products.find(name);
        if (productToRemoveStock != null) {
            System.out.print("Entrer la quantité à enlever: ");
            int quantityToRemove = Terminal.readIntInput();
            if (quantityToRemove <= productToRemoveStock.getStock().getCount()) {
                productToRemoveStock.getStock().removeQuantity(quantityToRemove);
                System.out.println("Stock retiré!");
            } else {
                System.out.println("Erreur : Pas assez de stock disponible.");
            }
        } else {
            System.out.println("Erreur : Produit non trouvé.");
        }
    }

    public void readAll() {
        //todo
    }
}
