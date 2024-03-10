package uqtr.management;

import uqtr.database.Database;
import uqtr.database.ProductRepository;
import uqtr.helpers.Terminal;
import uqtr.models.Product;

public class ProductManagement {

    private final ProductRepository products;

    public ProductManagement() {
        products = Database.getInstance().getProductRepository();
    }

    public void add() {
        System.out.print("Enter product name: ");
        String name = Terminal.readStringInput();
        System.out.print("Enter product price: ");
        int price = Terminal.readIntInput();
        System.out.print("Enter product quantity: ");
        int quantity = Terminal.readIntInput();
        products.add(new Product(name, price, quantity));
        System.out.println("uqtr.models.Product added!");
    }

    public void remove() {
        System.out.print("Enter product name to remove: ");
        String name = Terminal.readStringInput();
        products.remove(name);
    }

    public void update() {
        System.out.print("Enter product name to update: ");
        String name = Terminal.readStringInput();
        Product productToUpdate = products.find(name);
        if (productToUpdate != null) {
            System.out.print("Enter new product name: ");
            String newName = Terminal.readStringInput();
            System.out.print("Enter new product price: ");
            int newPrice = Terminal.readIntInput();
            System.out.print("Enter new product quantity: ");
            int newQuantity = Terminal.readIntInput();
            productToUpdate.setName(newName);
            productToUpdate.setPrice(newPrice);
            productToUpdate.setQuantity(newQuantity);
            System.out.println("uqtr.models.Product updated!");
        }
    }

    public void readAll() {
        //todo
    }
}
