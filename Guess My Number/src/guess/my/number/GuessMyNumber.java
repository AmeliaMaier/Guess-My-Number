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
        if (guess == answer) {
            System.out.println("Good work, " + guess + " is correct.");
            return true;
        }

        if (lastGuess != null) {
            if (Math.abs(answer - guess) < Math.abs(answer - lastGuess)) {
                System.out.println("You are getting warm.");
            }
            if (Math.abs(answer - guess) > Math.abs(answer - lastGuess)) {
                System.out.println("You are getting cold.");
            }
        }
        lastGuess = guess;
        System.out.println("Try again.");
        return false;
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
        } while (guess == null);
        return guess;
    }
}
