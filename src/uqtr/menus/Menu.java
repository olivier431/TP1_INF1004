package uqtr.menus;

import uqtr.helpers.Terminal;

public abstract class Menu {
    protected boolean userWantsToExit;
    protected int numberOfChoices;

    public void start() {
        while (!userWantsToExit) {
            display();
            redirectBasedOnChoice(Terminal.getDigitChoiceFromUser(1, 6));
        }
    }

    protected abstract void display();
    protected abstract void redirectBasedOnChoice(int choice);
}
