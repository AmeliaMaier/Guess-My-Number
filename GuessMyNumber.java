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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

       Scanner input = new Scanner(System.in);
        boolean correct = false;
        boolean keepGoing = false;
        char playAgain;
        Integer guess, lastGuess, answer;
        Random random = new Random();
        
        do
        {
            lastGuess = null;
            guess = null;
            playAgain = 'f';
            
            answer = random.nextInt(100);        
            //debug
            System.out.println("debugging    " + answer);
            //debug        
            try
            {
                System.out.print("Guess a number, 0 to 100.");
                guess = input.nextInt();
            }catch(InputMismatchException e)
            { 
                System.out.println("Please only enter a number.");
                input.nextLine();
            }

            while(correct == false)
            {
                if(guess != answer)
                {
                    if(lastGuess != null)
                    {
                        if(Math.abs(answer - guess) < Math.abs(answer - lastGuess))
                        { System.out.println("You are getting warm.");}
                        if(Math.abs(answer - guess) > Math.abs(answer - lastGuess))
                        { System.out.println("You are getting cold.");}
                    }
                    lastGuess = guess;
                    System.out.println("Try again.");
                    try
                    {
                        System.out.print("Guess a number, 0 to 100.");
                        guess = input.nextInt();
                    }catch(InputMismatchException e)
                    { 
                        System.out.println("Please only enter a number.");
                        input.nextLine();
                    }               
                }
                else
                {
                    System.out.println("Good work, " + guess + " is correct.");
                    correct = true;
                }
            }
            correct = false;
            do
            {
                try
                {
                    System.out.print("Do you want to play again? (Y/N)");
                    playAgain = input.next().charAt(0);
                }catch(InputMismatchException e)
                { 
                    System.out.println("Please only enter a letter.");
                    input.nextLine();
                }  
            }while(playAgain != 'y' && playAgain != 'Y' && playAgain != 'n'&& playAgain != 'N');

            if(playAgain == 'Y' || playAgain == 'y')
            {
                keepGoing = true;
            }
            else
            {
                keepGoing = false;
            }
            
        }while(keepGoing);
        
    }
    
    
}
