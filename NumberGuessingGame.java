import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalRounds = 0;
        int totalScore = 0;
        String playAgain = "yes";

        System.out.println("Welcome to the Number Guessing Game!");

        // Main game loop
        while (playAgain.equalsIgnoreCase("yes")) {
            totalRounds++;
            int generatedNumber = random.nextInt(100) + 1;  // Generate a random number between 1 and 100
            int attempts = 0;
            int maxAttempts = 10;
            int score = 0;

            System.out.println("\nRound " + totalRounds + ": Guess the number between 1 and 100. You have 10 attempts.");

            // Round loop for guessing
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < generatedNumber) {
                    System.out.println("Too low!");
                } else if (guess > generatedNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
                    score = 10 - attempts; // Calculate score based on attempts
                    break; // Exit the loop if the guess is correct
                }

                System.out.println("Attempts remaining: " + (maxAttempts - attempts));
            }

            if (attempts == maxAttempts && score == 0) {
                System.out.println("Sorry, you've used all attempts! The correct number was " + generatedNumber + ".");
            }

            totalScore += score;
            System.out.println("Your score for this round is: " + score);

            // Ask if the user wants to play another round
            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next();
        }

        // Display final results
        System.out.println("\nGame over! You played " + totalRounds + " rounds with a total score of " + totalScore + ".");
        scanner.close();
    }
}


