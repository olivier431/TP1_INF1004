package uqtr.menus;

import uqtr.helpers.Terminal;
import uqtr.management.SaleManagement;
import uqtr.models.Product;

public class SaleMenu {

    public static void display() {
        int choice;
        var saleManagement = new SaleManagement();
        do {
            Terminal.printSalesManagementMenu();
            choice = Terminal.getDigitChoiceFromUser(1, 2);
            switch (choice) {
                case 1 -> saleManagement.add();
                case 2 -> saleManagement.showAll();
            }
        } while (choice != 2);
    }
}
