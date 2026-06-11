import java.util.Scanner;

public class ResultGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Raj's Coaching Center Result Generator ===");
        
        double totalMarks = 0;
        final int TOTAL_SUBJECTS = 5;
        boolean isValidInput = true;
        
        // for-loop to iterate over subjects and collect marks
        for (int i = 1; i <= TOTAL_SUBJECTS; i++) {
            System.out.print("Enter marks for Subject " + i + " (out of 100): ");
            double marks = scanner.nextDouble();
            
            // Validation filter for marks
            if (marks < 0 || marks > 100) {
                System.out.println("Error: Marks should be between 0 and 100. Restarting calculation.");
                isValidInput = false;
                break;
            }
            totalMarks += marks;
        }
        
        if (isValidInput) {
            // Calculate average
            double average = totalMarks / TOTAL_SUBJECTS;
            
            // Convert average to an indicator for switch-case block (e.g., 85 / 10 = 8)
            int scoreKey = (int) average / 10;
            char grade;
            
            // Switch statement to determine final letter grades
            switch (scoreKey) {
                case 10:
                case 9:
                    grade = 'A'; // 90 to 100
                    break;
                case 8:
                    grade = 'B'; // 80 to 89
                    break;
                case 7:
                    grade = 'C'; // 70 to 79
                    break;
                case 6:
                    grade = 'D'; // 60 to 69
                    break;
                case 5:
                case 4:
                    grade = 'E'; // 40 to 59
                    break;
                default:
                    grade = 'F'; // Below 40 (Fail)
                    break;
            }
            
            System.out.println("\n----------------------------");
            System.out.printf("Total Aggregate Marks: %.2f / 500.00\n", totalMarks);
            System.out.printf("Calculated Average:     %.2f%%\n", average);
            System.out.println("Final Assigned Grade:   " + grade);
            System.out.println("----------------------------");
        }
        
        scanner.close();
    }
}