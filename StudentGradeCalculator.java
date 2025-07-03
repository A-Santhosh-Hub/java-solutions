import java.util.Scanner;

class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numSubjects = 5;
        int[] marks = new int[numSubjects];
        int total = 0;
        double average;
        char grade;

        System.out.println("=== Student Grade Calculator ===");

        // Input marks for each subject
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for Subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();

            // Input validation
            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid input. Marks should be between 0 and 100.");
                i--; // Ask for the same subject again
                continue;
            }

            total += marks[i];
        }

        // Calculate average
        average = (double) total / numSubjects;

        // Assign grade
        if (average >= 90) {
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        } else if (average >= 70) {
            grade = 'C';
        } else if (average >= 60) {
            grade = 'D';
        } else if (average >= 50) {
            grade = 'E';
        } else {
            grade = 'F'; // Fail
        }

        // Display results
        System.out.println("\n--- Result ---");
        System.out.println("Total Marks: " + total + "/" + (numSubjects * 100));
        System.out.printf("Average: %.2f\n", average);
        System.out.println("Grade: " + grade);
    }
}
