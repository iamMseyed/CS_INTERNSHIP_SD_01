package codSoft;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        System.out.println("Welcome to the Guess the Number Game!");

        try {
        	while (playAgain) {
                int secretNumber = random.nextInt(100) + 1; 
                int attempts = 0;
                final int maxAttempts = 5; 

                while (true) {
                    System.out.print("Guess the number between 1 and 100: ");
                    int guess = scanner.nextInt();
                    attempts++;

                    if (guess == secretNumber) {
                        System.out.println("Congratulations! You guessed the number " + secretNumber + " correctly in " + attempts + " attempts!");
                        break;
                    } else if (guess < secretNumber) {
                        System.out.println("Too low! Try again. ");
                    } else {
                        System.out.println("Too high! Try again. ");
                    }

                    if (attempts == maxAttempts) {
                        System.out.println("Sorry, you've reached the maximum number of attempts. \nThe correct number was " + secretNumber + ".");
                        break;
                    }
                }

                System.out.print("Do you want to play again? (y/n): ");
                String playAgainInput = scanner.next().toLowerCase();
                if (!playAgainInput.equals("y")) {
                    playAgain = false;
                }
            }
        }catch(InputMismatchException ime) {
        	System.err.println("Please enter number only!");
        }

        System.out.println("Good Bye!");
        scanner.close();
    }
}
