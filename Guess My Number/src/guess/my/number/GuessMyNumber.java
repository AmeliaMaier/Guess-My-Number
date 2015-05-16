/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guess.my.number;

import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author Lia
 */
public class GuessMyNumber {

    Scanner input = new Scanner(System.in);
    Integer lastGuess, answer;
    Random random = new Random();

    public static void main(String[] args) {
        // TODO code application logic here
        GuessMyNumber game = new GuessMyNumber();
    }

    public GuessMyNumber() {
        do {
            Initialize();
            //debug
            System.out.println("debugging    " + answer);
            //debug   
            while (!CheckGuess()) {
            }
        } while (PlayAgain());
    }

    private void Initialize() {
        lastGuess = null;
        answer = random.nextInt(100);
    }

    private boolean CheckGuess() {
        Integer guess = GetGuess();
        boolean status = StatusResponse(guess);
        lastGuess = guess;
        if (!status) {
            System.out.println("Try again.");
        }
        return status;

    }

    private boolean PlayAgain() {
        char playAgain = ' ';
        do {
            try {
                System.out.print("Do you want to play again? (Y/N)");
                playAgain = input.next().toUpperCase().charAt(0);
            } catch (InputMismatchException e) {
                System.out.println("Please only enter a letter.");
                input.nextLine();
            }
        } while (playAgain != 'Y' && playAgain != 'N');
        return (playAgain == 'Y');
    }

    private int GetGuess() {
        Integer guess = null;
        do {
            try {
                System.out.print("Guess a number, 0 to 100.");
                guess = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please only enter a number.");
                input.nextLine();
            }
        } while (guess == null || guess < 0 || guess > 100);
        return guess;
    }

    private boolean StatusResponse(int guess) {
        if (guess == answer) {
            System.out.println("Good work. " + answer + " is correct.");
            return true;
        }
        int difference = Math.abs(answer - guess);
        if (difference > 30) {
            System.out.println("You are FREEZING" + MovementResponse(difference, 1));
            return false;
        }
        if (difference > 20) {
            System.out.print("You are COLD" + MovementResponse(difference, 2));
            return false;
        }
        if (difference > 10) {
            System.out.print("You are COOL" + MovementResponse(difference, 3));
            return false;
        }
        if (difference > 5) {
            System.out.print("You are WARM" + MovementResponse(difference, 4));
            return false;
        }
        System.out.print("You are HOT" + MovementResponse(difference, 5));
        return false;

    }

    private String MovementResponse(int currentDifference, int switchCase) {
        if (lastGuess != null) {
            int lastDifference = Math.abs(answer - lastGuess);
            switch (switchCase) {
                case 1:
                case 2:
                    if (lastDifference > currentDifference) {
                        return " but you are getting WARMER.";
                    }
                    if (lastDifference < currentDifference) {
                        return " and you are getting COLDER.";
                    }
                    return ".";
                case 3:
                    if (lastDifference > currentDifference) {
                        return " but you are getting WARMER.";
                    }
                    if (lastDifference < currentDifference) {
                        return " and you are getting COOLER.";
                    }
                    return ".";
                case 4:
                    if (lastDifference > currentDifference) {
                        return " and you are getting WARMER.";
                    }
                    if (lastDifference < currentDifference) {
                        return " but you are getting COOLER.";
                    }
                    return ".";
                case 5:
                    if (lastDifference > currentDifference) {
                        return " and you are getting HOTTER.";
                    }
                    if (lastDifference < currentDifference) {
                        return " but you are getting COOLER.";
                    }
                    return ".";
                default:
                    return ".";
            }
        }
        return ".";

    }
}
