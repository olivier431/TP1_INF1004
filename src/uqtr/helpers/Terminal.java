package uqtr.helpers;

import java.util.Scanner;

public class Terminal {
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
