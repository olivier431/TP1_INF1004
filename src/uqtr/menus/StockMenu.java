package uqtr.menus;

import uqtr.helpers.Terminal;
import uqtr.management.StockManagement;
import uqtr.models.Product;

public class StockMenu {

    public static void display() {
        int choice;
        var stockManagement = new StockManagement();
        do {
            Terminal.printStockManagementMenu();
            choice = Terminal.getDigitChoiceFromUser(1, 3);
            switch (choice) {
                case 1 -> stockManagement.add();
                case 2 -> stockManagement.remove();
                case 3 -> stockManagement.readAll();
            }
        } while (choice != 3);
    }
}
