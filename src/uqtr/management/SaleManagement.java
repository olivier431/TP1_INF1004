package uqtr.management;

import uqtr.database.Database;
import uqtr.database.OrderRepository;
import uqtr.helpers.Terminal;
import uqtr.models.order.Order;
import uqtr.models.order.OrderRow;

public class SaleManagement {

    private final OrderRepository orders;

    public SaleManagement() {
        orders = Database.getInstance().getOrderRepository();
    }

    public void confirmSale() {
        var orderToProcess = orders.peek();
        if (orderToProcess == null) {
            System.out.println("Aucune commande en attente !");
            return;
        }
        System.out.printf("Commande à traiter : %d articles différents - %.2f", orderToProcess.getNumberOfRows(), orderToProcess.getTotal());
        checkStock(orderToProcess);
        tryToConfirmSale();
    }

    private void tryToCancelOrder() {
        System.out.print("Pas assez de stock pour traiter, retarder cette commande ? [O/N] :");
        var input = Terminal.readStringInput();
        if (!input.equalsIgnoreCase("O")) return;
        var order = orders.pop();
        orders.push(order);
    }

    private void tryToConfirmSale() {
        System.out.print("Confirmer cette vente ? [O/N] :");
        var input = Terminal.readStringInput();
        if (!input.equalsIgnoreCase("N")) return;
        var order = orders.pop();
        updateStock(order);
        Database.getInstance().getSaleRepository().add(order);
    }

    private void updateStock(Order order) {
        for (var row : order.getAllRows()) {
            row.getOrderedProduct().getStock().removeQuantity(row.getQuantityOrdered());
        }
    }

    private void checkStock(Order orderToProcess) {
        for (var row : orderToProcess.getAllRows()) {
            if (row.getOrderedProduct().getStock().getCount() < row.getQuantityOrdered()) {
                tryToCancelOrder();
                return;
            }
        }
    }

    public void showAll() {
        // todo : Implementer une méthode qui permet de voir l'historique des ventes
    }
}
