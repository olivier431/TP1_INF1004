package uqtr.menus;

import uqtr.helpers.Terminal;
import uqtr.management.OrderManagement;

public class OrderMenu extends Menu {
    private final OrderManagement orderManagement;

    public OrderMenu() {
        numberOfChoices = 3;
        orderManagement = new OrderManagement();
    }

    public void display() {
        Terminal.printOrderProcessingMenu();
    }

    @Override
    public void redirectBasedOnChoice(int choice) {
        switch (choice) {
            case 1 -> orderManagement.process();
            case 2 -> orderManagement.showAll();
            case 3 -> userWantsToExit = true;
        }
    }
}
