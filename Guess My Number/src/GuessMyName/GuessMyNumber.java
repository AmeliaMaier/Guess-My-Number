/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GuessMyName;

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
            while (!CheckGuess()) {
            }
        } while (PlayAgain());
    }

    private void Initialize() {
        lastGuess = null;
        answer = Math.abs(random.nextInt(101));
    }

    private boolean CheckGuess() {
        Integer guess = GetGuess();
        return StatusResponse(guess);
    }

    private int GetGuess() {
        Integer guess = null;
        do {
            try {
                System.out.print("Guess a number, 1 to 100.");
                guess = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please only enter a number.");
                input.nextLine();
            }
        } while (guess == null || guess < 1 || guess > 100);
        return guess;
    }

    private boolean StatusResponse(int guess) {
        if (guess == answer) {
            System.out.println("Good work. " + answer + " is correct.");
            return true;
        }
        int difference = Math.abs(answer - guess);
        if (difference > 30) {
            System.out.println("You are FREEZING" + ColdResponse(difference, "WARMER", "COLDER") + ".");
        } else if (difference > 20) {
            System.out.println("You are COLD" + ColdResponse(difference, "WARMER", "COLDER") + ".");
        } else if (difference > 10) {
            System.out.println("You are COOL" + ColdResponse(difference, "WARMER", "COOLER") + ".");
        } else if (difference > 5) {
            System.out.println("You are WARM" + HotResponse(difference, "WARMER", "COOLER") + ".");
        } else {
            System.out.println("You are HOT" + HotResponse(difference, "HOTTER", "COOLER") + ".");
        }
        System.out.println("Try agian.");
        lastGuess = guess;
        return false;
    }

    private String ColdResponse(int currentDifference, String hot, String cold) {
        if (lastGuess == null) {
            return "";
        }
        int lastDifference = Math.abs(answer - lastGuess);
        if (lastDifference > currentDifference) {
            return (" but you are getting " + hot);
        }
        if (lastDifference < currentDifference) {
            return (" and you are getting " + cold);
        }
        return "";
    }

    private String HotResponse(int currentDifference, String hot, String cold) {
        if (lastGuess == null) {
            return "";
        }
        int lastDifference = Math.abs(answer - lastGuess);
        if (lastDifference > currentDifference) {
            return (" and you are getting " + hot);
        }
        if (lastDifference < currentDifference) {
            return (" but you are getting " + cold);
        }
        return "";
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
}
