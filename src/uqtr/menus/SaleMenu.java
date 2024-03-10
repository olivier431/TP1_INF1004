package uqtr.menus;

import uqtr.helpers.Terminal;
import uqtr.management.SaleManagement;
import uqtr.models.Product;

public class SaleMenu extends Menu {
    private final SaleManagement saleManagement;

    public SaleMenu() {
        numberOfChoices = 3;
        saleManagement = new SaleManagement();
    }

    public void display() {
        Terminal.printSalesManagementMenu();
    }

    @Override
    public void redirectBasedOnChoice(int choice) {
        switch (choice) {
            case 1 -> saleManagement.add();
            case 2 -> saleManagement.showAll();
            case 3 -> userWantsToExit = true;
        }
    }
}
