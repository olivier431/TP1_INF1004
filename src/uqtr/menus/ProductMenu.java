package uqtr.menus;

import uqtr.helpers.Terminal;
import uqtr.management.ProductManagement;

public class ProductMenu extends Menu {
    private final ProductManagement productManagement ;

    public ProductMenu() {
        numberOfChoices = 5;
        productManagement = new ProductManagement();
    }

    @Override
    protected void display() {
        Terminal.printProductManagementMenu();
    }

    @Override
    protected void redirectBasedOnChoice(int choice) {
        switch (choice) {
            case 1 -> productManagement.add();
            case 2 -> productManagement.remove();
            case 3 -> productManagement.update();
            case 4 -> productManagement.readAll();
            case 5 -> userWantsToExit = true;
        }
    }
}
