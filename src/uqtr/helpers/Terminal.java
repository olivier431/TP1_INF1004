package uqtr.helpers;

import java.util.Scanner;

public class Terminal {

    public static void printStartMenu() {
        System.out.println("Bienvenue !\n");
        System.out.println("1) Gérer les produits");
        System.out.println("2) Gérer le stock");
        System.out.println("3) Traiter les commandes");
        System.out.println("4) Gérer les ventes");
        System.out.println("5) Générer un rapport");
        System.out.println("6) Quitter\n");
    }

    public static void printStockManagementMenu() {
        System.out.println("\nGestion du Stock:\n");
        System.out.println("1) Ajouter du stock");
        System.out.println("2) Retirer du stock");
        System.out.println("3) Afficher le stock");
        System.out.println("4) Retour au menu principal\n");
    }

    public static void printProductManagementMenu() {
        System.out.println("\nGestion des Produits:\n");
        System.out.println("1) Ajouter un produit");
        System.out.println("2) Supprimer un produit");
        System.out.println("3) Modifier un produit");
        System.out.println("4) Afficher tous les produits");
        System.out.println("5) Retour au menu principal\n");
    }

    public static void printSalesManagementMenu() {
        System.out.println("\nGestion des Ventes:\n");
        System.out.println("1) Enregistrer une vente");
        System.out.println("2) Afficher l'historique des ventes");
        System.out.println("3) Retour au menu principal\n");
    }

    public static void printOrderProcessingMenu() {
        System.out.println("\nTraitement des Commandes:\n");
        System.out.println("1) Traiter une commande");
        System.out.println("2) Afficher l'historique des commandes");
        System.out.println("3) Retour au menu principal\n");
    }

    public static int getDigitChoiceFromUser(int minChoice, int maxChoice) {
        int input;
        while (true) {
            System.out.print("Votre choix: ");
            input = readIntInput();
            if (isIntInRange(input, minChoice, maxChoice)) {
                return input;
            }
            System.out.println("Erreur : Veuillez réessayer");
        }
    }

    public static String readStringInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int readIntInput() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.println("Erreur : Veuillez entrer un entier.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static double readDoubleInput() {
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextDouble()) {
            System.out.println("Erreur : Veuillez entrer un nombre réel.");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    private static boolean isIntInRange(int input, int min, int max) {
        return input >= min && input <= max;
    }
}
