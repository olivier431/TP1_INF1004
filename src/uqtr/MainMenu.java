package uqtr;

import uqtr.helpers.Terminal;
import uqtr.menus.*;

public class MainMenu {
    private boolean userWantsToExit;

    public void start() {
        while (!userWantsToExit) {
            Terminal.printStartMessage();
            redirectBasedOnStartChoice(Terminal.getDigitChoiceFromUser(1, 5));
        }
    }

    private void redirectBasedOnStartChoice(int choice) {
        switch (choice) {
            case 1 -> ProductMenu.display();
            case 2 -> StockMenu.display();
            case 3 -> OrderMenu.display();
            case 4 -> SaleMenu.display();
            case 5 -> ReportMenu.display();
            case 6 -> userWantsToExit = true;
        }
    }
}
