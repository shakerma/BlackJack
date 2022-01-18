package coe318.lab5;

import java.util.Scanner;

public class SimpleUI implements UserInterface {

    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);

    @Override
    public void setGame(BlackjackGame game) {
        this.game = game;
    }

    @Override
    public void display() {
        System.out.println("House Holds:" + game.getHouseCards());
        System.out.println("You Hold:" + game.getYourCards());

    }

    @Override
    public boolean hitMe() {
        System.out.println("Another card?");
        String answer = user.nextLine();
        if (answer.equals("y")) {
            return true;
        }
        return false;
    }

    @Override
    public void gameOver() {
        display();
        int myScore = game.score(game.getYourCards());
        int houseScore = game.score(game.getHouseCards());

        System.out.println("Your score:" + myScore);
        System.out.println("House score:" + houseScore);

        if (myScore == houseScore|| myScore>21) {
            System.out.println("House wins");
        } else if (myScore <= 21 && (myScore > houseScore || houseScore > 21)) {
            System.out.println("You win");
        } else {
            System.out.println("House wins");
        }
    }

}
