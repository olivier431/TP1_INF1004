package uqtr.menus;

import uqtr.helpers.Terminal;
import uqtr.management.ProductManagement;
import uqtr.models.Product;

public class ProductMenu {

    public static void display() {
        int choice;
        var productManagement = new ProductManagement();
        do {
            Terminal.printProductManagementMenu();
            choice = Terminal.getDigitChoiceFromUser(1, 4);
            switch (choice) {
                case 1 -> productManagement.add();
                case 2 -> productManagement.remove();
                case 3 -> productManagement.update();
                case 4 -> productManagement.readAll();

                //todo : show
            }
        } while (choice != 4);
    }
}
