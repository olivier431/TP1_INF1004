package uqtr.management;

import uqtr.database.Database;
import uqtr.database.ProductRepository;
import uqtr.helpers.Terminal;
import uqtr.models.Product;

public class SaleManagement {

    private final ProductRepository products;

    public SaleManagement() {
        products = Database.getInstance().getProductRepository();
    }

    public void add() {
        System.out.print("Enter product name sold: ");
        String name = Terminal.readStringInput();
        Product productSold = products.find(name);
        if (productSold != null && productSold.getQuantity() > 0) {
            System.out.print("Enter quantity sold: ");
            int quantitySold = Terminal.readIntInput();
            if (quantitySold <= productSold.getQuantity()) {
                int newQuantity = productSold.getQuantity() - quantitySold;
                productSold.setQuantity(newQuantity);
                System.out.println("Sale recorded!");
            } else {
                System.out.println("Error: Not enough stock available for sale.");
            }
        } else {
            System.out.println("Error: uqtr.models.Product not found or out of stock.");
        }
    }

    public void showAll() {
        // Implementer une méthode qui permet de voir l'historique des ventes
    }
}
