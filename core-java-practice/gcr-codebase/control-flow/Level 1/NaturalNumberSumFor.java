// Program to find sum of natural numbers
// using for loop and compare with formula

import java.util.Scanner;

class NaturalNumberSumFor {
    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a natural number: ");
        int number = input.nextInt();

        // Check natural number
        if (number > 0) {

            // Calculate sum using formula
            int formulaSum =
                    number * (number + 1) / 2;

            // Calculate sum using for loop
            int forLoopSum = 0;

            for (int counter = 1;
                 counter <= number;
                 counter++) {

                forLoopSum += counter;
            }

            // Display results
            System.out.println(
                    "Sum using formula = "
                    + formulaSum);

            System.out.println(
                    "Sum using for loop = "
                    + forLoopSum);

            // Compare results
            if (formulaSum == forLoopSum) {
                System.out.println(
                        "Both computations are correct.");
            }

        } else {
            System.out.println(
                    "Not a natural number.");
        }

        // Close scanner
        input.close();
    }
}