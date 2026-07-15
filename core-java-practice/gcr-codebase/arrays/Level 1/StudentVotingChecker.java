import java.util.Scanner;

/**
 * Class to check voting eligibility for 10 students based on their age.
 */
class StudentVotingChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Define an array to hold the age of 10 students
        int[] studentAges = new int[10];
        
        // Take user input for each student's age
        System.out.println("Enter the age of 10 students:");
        for (int i = 0; i < studentAges.length; i++) {
            System.out.print("Student " + (i + 1) + ": ");
            studentAges[i] = input.nextInt();
        }
        
        System.out.println("\n--- Voting Eligibility Results ---");
        // Loop through the array using length property and validate eligibility
        for (int i = 0; i < studentAges.length; i++) {
            int age = studentAges[i];
            
            if (age < 0) {
                System.out.println("Student " + (i + 1) + ": Invalid age (" + age + ").");
            } else if (age >= 18) {
                System.out.println("The student with the age " + age + " can vote.");
            } else {
                System.out.println("The student with the age " + age + " cannot vote.");
            }
        }
        
        input.close();
    }
}