package uqtr.menus;

import uqtr.helpers.Terminal;

public class MainMenu extends Menu {

    public MainMenu() {
        numberOfChoices = 5;
    }

    @Override
    protected void display() {
        System.out.println("Bienvenue !\n");
        System.out.println("1) Gérer les produits");
        System.out.println("2) Gérer le stock");
        System.out.println("3) Commandes/Ventes");
        System.out.println("4) Générer un rapport");
        System.out.println("5) Quitter\n");
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
