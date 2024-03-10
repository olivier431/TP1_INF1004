package uqtr.menus;

import uqtr.helpers.Terminal;

public class MainMenu extends Menu {

    public MainMenu() {
        numberOfChoices = 6;
    }

    @Override
    public void display() {
        Terminal.printStartMenu();
    }

    @Override
    public void redirectBasedOnChoice(int choice) {
        switch (choice) {
            case 1 -> new ProductMenu().display();
            case 2 -> new StockMenu().display();
            case 3 -> new OrderMenu().display();
            case 4 -> new SaleMenu().display();
            case 5 -> new ReportMenu().display();
            case 6 -> userWantsToExit = true;
        }
    }
}
