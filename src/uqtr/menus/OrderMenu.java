package uqtr.menus;

import uqtr.helpers.Terminal;
import uqtr.management.OrderManagement;
import uqtr.management.SaleManagement;

public class OrderMenu extends Menu {
    private final OrderManagement orderManagement;
    private final SaleManagement saleManagement;

    public OrderMenu() {
        numberOfChoices = 3;
        orderManagement = new OrderManagement();
        saleManagement = new SaleManagement();
    }

    @Override
    protected void display() {
        Terminal.printOrderProcessingMenu();
    }

    @Override
    protected void redirectBasedOnChoice(int choice) {
        switch (choice) {
            case 1 -> orderManagement.order();
            case 2 -> saleManagement.confirmSale();
            case 3 -> userWantsToExit = true;
        }
    }
}
