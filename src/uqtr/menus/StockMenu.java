package uqtr.menus;

import uqtr.helpers.Terminal;
import uqtr.management.StockManagement;
import uqtr.models.Product;

public class StockMenu extends Menu {
    private final StockManagement stockManagement;

    public StockMenu() {
        numberOfChoices = 4;
        stockManagement = new StockManagement();
    }

    public void display() {
        Terminal.printStockManagementMenu();
    }

    @Override
    public void redirectBasedOnChoice(int choice) {
        switch (choice) {
            case 1 -> stockManagement.add();
            case 2 -> stockManagement.remove();
            case 3 -> stockManagement.readAll();
            case 4 -> userWantsToExit = true;
        }
    }
}
