import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;

public class Terminal {

    public static void printStartMessage() {
        System.out.println("Bienvenue !\n");
        System.out.println("1) Gérer les produits");
        System.out.println("2) Gérer le stock");
        System.out.println("3) Traiter les commandes");
        System.out.println("4) Gérer les ventes");
        System.out.println("5) Générer un rapport\n");
    }

    public static int getDigitChoiceFromUser(int minChoice, int maxChoice) {
        int input;
        while (true) {
            input = readInt();
            if (isIntInRange(input, minChoice, maxChoice)) {
                return input;
            }
            System.out.println("Erreur: Veuillez réessayer");
        }
    }

    private static int readInt() {
        var scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static boolean isIntInRange(int input, int min, int max) {
        return input >= min && input <= max;
    }
}
