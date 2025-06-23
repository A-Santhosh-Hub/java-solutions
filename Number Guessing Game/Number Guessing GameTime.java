import java.util.Scanner;
import java.util.Random;

class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        boolean playAgain = true;

        System.out.println("🎯 Welcome to the Number Guessing Game!");

        while (playAgain) {
            int secretNumber = rand.nextInt(100) + 1;
            int guess;
            int attempts = 0;

            long startTime = System.currentTimeMillis();

            System.out.println("\nI'm thinking of a number between 1 and 100.");

            while (true) {
                System.out.print("Enter your guess: ");
                guess = input.nextInt();
                attempts++;

                if (guess < secretNumber) {
                    System.out.println("Too low! 🔽 Try again.");
                } else if (guess > secretNumber) {
                    System.out.println("Too high! 🔼 Try again.");
                } else {
                    long endTime = System.currentTimeMillis();
                    double timeTaken = (endTime - startTime) / 1000.0;

                    System.out.println("🎉 Correct! You guessed the number in " + attempts + " attempts.");
                    System.out.println("⏱️ Time taken: " + timeTaken + " seconds.");
                    break;
                }
            }

            System.out.print("🔁 Do you want to play again? (yes/no): ");
            input.nextLine(); // consume leftover newline
            String response = input.nextLine().toLowerCase();

            if (!response.equals("yes") && !response.equals("y")) {
                playAgain = false;
                System.out.println("👋 Thanks for playing!");
            }
        }

        input.close();
    }
}
