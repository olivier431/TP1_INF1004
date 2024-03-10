package uqtr.management;

import uqtr.database.Database;
import uqtr.database.ProductRepository;
import uqtr.helpers.Terminal;
import uqtr.models.Product;
import uqtr.models.ProductOrder;

public class OrderManagement {

    private final ProductRepository products;

    public OrderManagement() {
        products = Database.getInstance().getProductRepository();
    }

    public void process() {
        //todo : revoir
        System.out.print("Enter product name to process order: ");
        String name = Terminal.readStringInput();
        Product productToProcessOrder = products.find(name);
        if (productToProcessOrder != null && productToProcessOrder.getQuantity() > 0) {
            System.out.print("Enter quantity to process: ");
            int quantityToProcess = Terminal.readIntInput();
            if (quantityToProcess <= productToProcessOrder.getQuantity()) {
                ProductOrder newOrder = new ProductOrder(quantityToProcess, productToProcessOrder);
                //TODO: Faire dequoi avec la commande
                System.out.println("Order processed!");
            } else {
                System.out.println("Error: Not enough stock available to process order.");
            }
        } else {
            System.out.println("Error: uqtr.models.Product not found or out of stock.");
        }
    }

    public void showAll() {
        // Implementer une méthode qui permet d'afficher l'historique des commandes
    }
}
