// Program to check voting eligibility

import java.util.Scanner;

class VotingEligibility {
    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter age: ");
        int age = input.nextInt();

        // Check voting eligibility
        if (age >= 18) {
            System.out.println("The person's age is "
                    + age +
                    " and can vote.");
        } else {
            System.out.println("The person's age is "
                    + age +
                    " and cannot vote.");
        }

        // Close scanner
        input.close();
    }
}