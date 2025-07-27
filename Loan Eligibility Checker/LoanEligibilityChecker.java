import java.util.Scanner;

/**
 * A simple Java program to determine loan eligibility based on user input.
 */
class LoanEligibilityChecker {

    // --- Eligibility Criteria Constants ---
    // By defining these as constants, it's easy to change the rules later.
    private static final int MINIMUM_AGE = 21;
    private static final double MINIMUM_INCOME = 25000.00;
    private static final int MINIMUM_CREDIT_SCORE = 650;

    public static void main(String[] args) {

        // Create a Scanner object to read input from the user.
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("--- Loan Eligibility Application ---");
        System.out.println("Please provide the following details to check your eligibility.");

        // --- Get User Input ---

        // 1. Get Age
        int userAge = 0;
        System.out.print("Enter your current age: ");
        // Use a try-catch block to handle non-integer input gracefully.
        try {
            userAge = inputScanner.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number for age.");
            inputScanner.close(); // Close the scanner before exiting
            return; // Exit the program
        }


        // 2. Get Annual Income
        double userIncome = 0.0;
        System.out.print("Enter your total annual income: ");
        // Use a try-catch block for robust input handling.
        try {
            userIncome = inputScanner.nextDouble();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number for income.");
            inputScanner.close();
            return;
        }


        // 3. Get Credit Score
        int userCreditScore = 0;
        System.out.print("Enter your credit score (e.g., 300-850): ");
        // Use a try-catch block for robust input handling.
        try {
            userCreditScore = inputScanner.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid number for credit score.");
            inputScanner.close();
            return;
        }


        // --- Check Eligibility ---

        // We will use a boolean flag to track eligibility.
        boolean isEligible = true;

        // A StringBuilder to store reasons for ineligibility.
        StringBuilder reasons = new StringBuilder();

        if (userAge < MINIMUM_AGE) {
            isEligible = false;
            reasons.append(" - You must be at least " + MINIMUM_AGE + " years old.\n");
        }

        if (userIncome < MINIMUM_INCOME) {
            isEligible = false;
            reasons.append(" - Your annual income must be at least $" + String.format("%,.2f", MINIMUM_INCOME) + ".\n");
        }

        if (userCreditScore < MINIMUM_CREDIT_SCORE) {
            isEligible = false;
            reasons.append(" - Your credit score must be at least " + MINIMUM_CREDIT_SCORE + ".\n");
        }


        // --- Display Result ---

        System.out.println("\n--- Application Result ---");
        if (isEligible) {
            System.out.println("Congratulations! You are eligible for a loan.");
            System.out.println("Based on our preliminary checks, you meet all the minimum requirements.");
        } else {
            System.out.println("We're sorry, but you are not eligible for a loan at this time.");
            System.out.println("Reasons for ineligibility:");
            System.out.print(reasons.toString());
        }

        // Always close the scanner when you're done with it to free up resources.
        inputScanner.close();
    }
}

