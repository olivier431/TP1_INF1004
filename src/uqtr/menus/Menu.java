package uqtr.menus;

import uqtr.helpers.Terminal;

public abstract class Menu {
    protected boolean userWantsToExit;
    protected int numberOfChoices;

    public void start() {
        while (!userWantsToExit) {
            Terminal.printStartMenu();
            redirectBasedOnChoice(Terminal.getDigitChoiceFromUser(1, 6));
        }
    }

    public abstract void display();
    public abstract void redirectBasedOnChoice(int choice);
}
