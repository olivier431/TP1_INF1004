package uqtr.menus;

import uqtr.helpers.Terminal;
import uqtr.management.OrderManagement;
import uqtr.models.Product;
import uqtr.models.ProductOrder;

public class OrderMenu {

    public static void display() {
        // Implementer order processing
        int choice;
        var orderManagement = new OrderManagement();
        do {
            Terminal.printOrderProcessingMenu();
            choice = Terminal.getDigitChoiceFromUser(1, 2);
            switch (choice) {
                case 1 -> orderManagement.process();
                case 2 -> orderManagement.showAll();
            }
        } while (choice != 2);
    }
}
