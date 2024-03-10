package uqtr.menus;

import uqtr.helpers.Terminal;
import uqtr.management.StockManagement;

public class StockMenu extends Menu {
    private final StockManagement stockManagement;

    public StockMenu() {
        numberOfChoices = 4;
        stockManagement = new StockManagement();
    }

    @Override
    protected void display() {
        System.out.println("\nGestion du Stock:\n");
        System.out.println("1) Ajouter du stock");
        System.out.println("2) Retirer du stock");
        System.out.println("3) Afficher le stock");
        System.out.println("4) Retour au menu principal\n");
    }

    @Override
    protected void redirectBasedOnChoice(int choice) {
        switch (choice) {
            case 1 -> stockManagement.add();
            case 2 -> stockManagement.remove();
            case 3 -> stockManagement.readAll();
            case 4 -> userWantsToExit = true;
        }
    }
}
