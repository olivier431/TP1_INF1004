package uqtr.management;

import uqtr.database.Database;
import uqtr.database.OrderRepository;
import uqtr.database.ProductRepository;
import uqtr.helpers.Terminal;
import uqtr.models.order.Order;
import uqtr.models.product.Product;
import uqtr.models.order.OrderRow;

public class OrderManagement {

    private final ProductRepository products;

    public OrderManagement() {
        products = Database.getInstance().getProductRepository();
    }

    public void order() {
        var order = new Order();
        String name;
        do {
            System.out.print("Entrer le nom du produit à commander ([ENTER] pour terminer la commande): ");
            name = Terminal.readStringInput();
            var row = orderProduct(name);
            if (row == null) continue;
            order.addRow(row);
        } while (name.equals(""));
        order.confirm();
        Database.getInstance().getOrderRepository().push(order);
        System.out.printf("Commande effectuée! (Sous-total: %.2f)\n", order.getTotal());
    }

    public void showAll() {
        // Implementer une méthode qui permet d'afficher l'historique des commandes
    }

    private OrderRow orderProduct(String name) {
        if (name.equals("")) return null;
        Product product = products.find(name);
        if (product == null || product.getStock().getCount() <= 0) {
            System.out.println("Erreur: Produit non trouvé ou hors de stock.");
            return null;
        }
        var quantity = getQuantityToOrder(product);
        if (quantity == 0) return null;
        return new OrderRow(quantity, product);
    }

    private int getQuantityToOrder(Product product) {
        System.out.print("Entrer la quantité à acheter: ");
        int quantityToOrder = Terminal.readIntInput();
        if (quantityToOrder <= product.getStock().getCount()) {
            return quantityToOrder;
        }
        System.out.println("Erreur: Stock insuffisant pour cet article.");
        return 0;
    }
}
