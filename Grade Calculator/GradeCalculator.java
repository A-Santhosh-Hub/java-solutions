import java.util.Scanner; // Import the Scanner class to get user input

public class GradeCalculator {

    public static void main(String[] args) {
        // Create a Scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        // --- 1. Get Student's Name ---
        System.out.print("Enter student's name: ");
        // Use nextLine() to read the full name, including spaces
        String studentName = scanner.nextLine();

        // --- 2. Get Number of Scores ---
        System.out.print("How many test scores will you enter for " + studentName + "? ");
        int numberOfScores = scanner.nextInt();

        // Important: Consume the leftover newline character after reading the integer.
        // If we don't do this, the next nextLine() call might read this empty line.
        scanner.nextLine();

        // Basic validation: Ensure the user enters a positive number of scores
        if (numberOfScores <= 0) {
            System.out.println("No scores to process. Please enter a number greater than 0 next time.");
            scanner.close(); // Always close the scanner when done
            return; // Exit the program gracefully
        }

        // --- 3. Get Test Scores and Calculate Total ---
        double totalScore = 0; // Initialize total score to 0. Use double for potential decimal scores.

        System.out.println("\nEnter " + numberOfScores + " scores (each between 0 and 100):");

        // Loop to get each individual score
        for (int i = 1; i <= numberOfScores; i++) {
            System.out.print("Enter score " + i + ": ");
            double score = scanner.nextDouble();

            // Optional: Basic score validation to ensure scores are within a reasonable range
            if (score < 0 || score > 100) {
                System.out.println("Invalid score. Please enter a score between 0 and 100.");
                i--; // Decrement 'i' so this score is asked for again
                continue; // Skip the rest of this loop iteration and go to the next one
            }
            totalScore += score; // Add the valid score to the running total
        }

        // Another Important: Consume the leftover newline character after the last double input.
        // This is good practice if you were to ask for more String input after numbers.
        scanner.nextLine();

        // --- 4. Calculate Average Score ---
        // Ensure numberOfScores is not 0 to prevent division by zero error (already handled above)
        double averageScore = totalScore / numberOfScores;

        // --- 5. Determine Letter Grade ---
        char letterGrade; // Declare a character variable for the grade

        if (averageScore >= 90) {
            letterGrade = 'A';
        } else if (averageScore >= 80) {
            letterGrade = 'B';
        } else if (averageScore >= 70) {
            letterGrade = 'C';
        } else if (averageScore >= 60) {
            letterGrade = 'D';
        } else {
            letterGrade = 'F';
        }

        // --- 6. Display Results ---
        System.out.println("\n--- Student Grade Report ---");
        System.out.println("Student Name: " + studentName);
        // Print total score (cast to int if you want it without decimals)
        System.out.println("Total Score: " + (int)totalScore);
        System.out.println("Number of Scores Entered: " + numberOfScores);
        // Use printf for formatted output, showing average score with 2 decimal places
        System.out.printf("Average Score: %.2f\n", averageScore);
        System.out.println("Letter Grade: " + letterGrade);

        // --- Clean up: Close the Scanner ---
        // It's good practice to close the Scanner when you're done with it to release system resources.
        scanner.close();
    }
}
