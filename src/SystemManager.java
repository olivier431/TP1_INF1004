public class SystemManager {

    public void start() {
        Terminal.printStartMessage();
        redirectBasedOnStartChoice(Terminal.getDigitChoiceFromUser(1, 5));
    }

    private void redirectBasedOnStartChoice(int choice) {
        switch (choice) {
            case 1 :
                //Gestion produits
                break;
            case 2 :
                //Gestion stock
                break;
            case 3 :
                //Traiter commande
                break;
            case 4 :
                //Gestion ventes
                break;
            case 5 :
                //Rapports
                break;
        }
    }
}
