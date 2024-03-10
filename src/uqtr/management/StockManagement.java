package uqtr.management;

import uqtr.database.Database;
import uqtr.database.ProductRepository;
import uqtr.helpers.Terminal;
import uqtr.models.Product;

public class StockManagement {
    private final ProductRepository products;

    public StockManagement() {
        products = Database.getInstance().getProductRepository();
    }
    public void add() {
        System.out.print("Enter product name to add stock: ");
        String name = Terminal.readStringInput();
        Product productToAddStock = products.find(name);
        if (productToAddStock != null) {
            System.out.print("Enter quantity to add: ");
            int quantityToAdd = Terminal.readIntInput();
            int newQuantity = productToAddStock.getQuantity() + quantityToAdd;
            productToAddStock.setQuantity(newQuantity);
            System.out.println("Stock added!");
        } else {
            System.out.println("Error: Product not found.");
        }
    }

    public void remove() {
        System.out.print("Enter product name to remove stock: ");
        String name = Terminal.readStringInput();
        Product productToRemoveStock = products.find(name);
        if (productToRemoveStock != null) {
            System.out.print("Enter quantity to remove: ");
            int quantityToRemove = Terminal.readIntInput();
            if (quantityToRemove <= productToRemoveStock.getQuantity()) {
                int newQuantity = productToRemoveStock.getQuantity() - quantityToRemove;
                productToRemoveStock.setQuantity(newQuantity);
                System.out.println("Stock removed!");
            } else {
                System.out.println("Error: Not enough stock available to remove.");
            }
        } else {
            System.out.println("Error: Product not found.");
        }
    }

    public void readAll() {
        products.showAll();
    }

}
