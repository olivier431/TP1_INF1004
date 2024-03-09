package menus;

import database.ProductRepository;
import helpers.Terminal;
import models.Product;
import models.ProductOrder;

public class MainMenu {

    private ProductRepository productRepository;

    public void start() {
        productRepository = new ProductRepository();
        while (true) {
            Terminal.printStartMessage();
            redirectBasedOnStartChoice(Terminal.getDigitChoiceFromUser(1, 5));
        }
    }

    private void redirectBasedOnStartChoice(int choice) {
        switch (choice) {
            case 1 :
                manageProducts();
                break;
            case 2 :
                manageStock();
                break;
            case 3 :
                //Manage orders
                break;
            case 4 :
                manageSales();
                break;
            case 5 :
                generateReports();
                break;
        }
    }

    private void manageProducts() {
        int choice;
        do {
            Terminal.printProductManagementMenu();
            choice = Terminal.getDigitChoiceFromUser(1, 4);
            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    removeProduct();
                    break;
                case 3:
                    updateProduct();
                    break;
                case 4:
                    productRepository.showAll();
                    break;
            }
        } while (choice != 4);
    }

    private void addProduct() {
        System.out.print("Enter product name: ");
        String name = Terminal.readStringInput();
        System.out.print("Enter product price: ");
        int price = Terminal.readIntInput();
        System.out.print("Enter product quantity: ");
        int quantity = Terminal.readIntInput();
        productRepository.add(new Product(name, price, quantity));
        System.out.println("models.Product added!");
    }

    private void removeProduct() {
        System.out.print("Enter product name to remove: ");
        String name = Terminal.readStringInput();
        productRepository.remove(name);
    }

    private void updateProduct() {
        System.out.print("Enter product name to update: ");
        String name = Terminal.readStringInput();
        Product productToUpdate = productRepository.find(name);
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
            System.out.println("models.Product updated!");
        }
    }

    private void manageStock() {
        // Implementer stock management
        int choice;
        do {
            Terminal.printStockManagementMenu();
            choice = Terminal.getDigitChoiceFromUser(1, 3);
            switch (choice) {
                case 1:
                    addStock();
                    break;
                case 2:
                    removeStock();
                    break;
                case 3:
                    showStock();
                    break;
            }
        } while (choice != 3);
    }

    private void addStock() {
        System.out.print("Enter product name to add stock: ");
        String name = Terminal.readStringInput();
        Product productToAddStock = productRepository.find(name);
        if (productToAddStock != null) {
            System.out.print("Enter quantity to add: ");
            int quantityToAdd = Terminal.readIntInput();
            int newQuantity = productToAddStock.getQuantity() + quantityToAdd;
            productToAddStock.setQuantity(newQuantity);
            System.out.println("Stock added!");
        } else {
            System.out.println("Error: models.Product not found.");
        }
    }

    private void removeStock() {
        System.out.print("Enter product name to remove stock: ");
        String name = Terminal.readStringInput();
        Product productToRemoveStock = productRepository.find(name);
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
            System.out.println("Error: models.Product not found.");
        }
    }

    private void showStock() {
        productRepository.showAll();
    }


    private void processOrders() {
        // Implementer order processing
        int choice;
        do {
            Terminal.printOrderProcessingMenu();
            choice = Terminal.getDigitChoiceFromUser(1, 2);
            switch (choice) {
                case 1:
                    processOrder();
                    break;
                case 2:
                    showOrders();
                    break;
            }
        } while (choice != 2);
    }
    private void processOrder() {
        System.out.print("Enter product name to process order: ");
        String name = Terminal.readStringInput();
        Product productToProcessOrder = productRepository.find(name);
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
            System.out.println("Error: models.Product not found or out of stock.");
        }
    }

    private void showOrders() {
        // Implementer une méthode qui permet d'afficher l'historique des commandes
    }

    private void manageSales() {
        // Implementer sales management
        int choice;
        do {
            Terminal.printSalesManagementMenu();
            choice = Terminal.getDigitChoiceFromUser(1, 2);
            switch (choice) {
                case 1:
                    recordSale();
                    break;
                case 2:
                    showSales();
                    break;
            }
        } while (choice != 2);
    }

    private void recordSale() {
        System.out.print("Enter product name sold: ");
        String name = Terminal.readStringInput();
        Product productSold = productRepository.find(name);
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
            System.out.println("Error: models.Product not found or out of stock.");
        }
    }

    private void showSales() {
        // Implementer une méthode qui permet de voir l'historique des ventes
    }

    private void generateReports() {
        // Implementer report generation
        System.out.println("Generating reports...");
        // Implement logic to generate reports
        System.out.println("Reports generated!");
    }
}
