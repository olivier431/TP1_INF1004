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
        System.out.printf("Commande à traiter : %d produit(s) unique(s) - %.2f$\n", orderToProcess.getNumberOfRows(), orderToProcess.getTotal());
        if (!checkStock(orderToProcess)) return;
        tryToConfirmSale();
    }

    private void tryToCancelOrder() {
        System.out.print("Pas assez de stock pour traiter, retarder cette commande (N pour annuler) ? [O/N] :");
        var input = Terminal.readStringInput();
        if (!input.equalsIgnoreCase("O")) return;
        var order = orders.pop();
        orders.push(order);
        System.out.println("Commande mise en arrière de la file d'attente.");
    }

    private void tryToConfirmSale() {
        System.out.print("Confirmer cette vente ? [O/N] :");
        var input = Terminal.readStringInput();
        if (!input.equalsIgnoreCase("O")) return;
        var order = orders.pop();
        updateStock(order);
        Database.getInstance().getSaleRepository().add(order);
        System.out.println("Vente confirmée !");

    }

    private void updateStock(Order order) {
        for (var row : order.getAllRows()) {
            row.getOrderedProduct().getStock().removeQuantity(row.getQuantityOrdered());
        }
    }

    private boolean checkStock(Order orderToProcess) {
        for (var row : orderToProcess.getAllRows()) {
            if (row.getOrderedProduct().getStock().getCount() < row.getQuantityOrdered()) {
                tryToCancelOrder();
                return false;
            }
        }
        return true;
    }
}
