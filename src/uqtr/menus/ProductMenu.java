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
        System.out.println("\nGestion des Produits:\n");
        System.out.println("1) Ajouter un produit");
        System.out.println("2) Supprimer un produit");
        System.out.println("3) Modifier un produit");
        System.out.println("4) Afficher tous les produits");
        System.out.println("5) Retour au menu principal\n");
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
