package uqtr.menus;

import uqtr.helpers.Terminal;

public class MainMenu extends Menu {

    public MainMenu() {
        numberOfChoices = 5;
    }

    @Override
    protected void display() {
        Terminal.printStartMenu();
    }

    @Override
    protected void redirectBasedOnChoice(int choice) {
        switch (choice) {
            case 1 -> new ProductMenu().start();
            case 2 -> new StockMenu().start();
            case 3 -> new OrderMenu().start();
            case 4 -> new ReportMenu().start();
            case 5 -> userWantsToExit = true;
        }
    }
}
