package uqtr.menus;

import uqtr.ReportGenerator;

public class ReportMenu extends Menu {
    private final ReportGenerator reportGenerator;

    public ReportMenu() {
        numberOfChoices = 5;
        reportGenerator = new ReportGenerator();
    }

    @Override
    protected void display() {
        System.out.println("\nGénération des rapports:\n");
        System.out.println("1) Afficher ventes");
        System.out.println("2) Afficher produits les plus vendus");
        System.out.println("3) Afficher produits en rupture de stock");
        System.out.println("4) Retour au menu principal\n");
    }

    @Override
    protected void redirectBasedOnChoice(int choice) {
        switch (choice) {
            case 1 -> reportGenerator.printSalesReport();
            case 2 -> reportGenerator.printBestSellingReport();
            case 3 -> reportGenerator.printOutOfStockReport();
            case 4 -> userWantsToExit = true;
        }

    }
}
