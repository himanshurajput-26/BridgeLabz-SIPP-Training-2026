// Program to find sum of natural numbers
// using while loop and compare with formula

import java.util.Scanner;

class NaturalNumberSumWhile {
    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a natural number: ");
        int number = input.nextInt();

        // Check natural number
        if (number > 0) {

            // Calculate using formula
            int formulaSum =
                    number * (number + 1) / 2;

            // Calculate using while loop
            int whileSum = 0;
            int counter = 1;

            while (counter <= number) {
                whileSum += counter;
                counter++;
            }

            // Display results
            System.out.println("Sum using formula = "
                    + formulaSum);

            System.out.println("Sum using while loop = "
                    + whileSum);

            // Compare results
            if (formulaSum == whileSum) {
                System.out.println(
                        "Both computations are correct.");
            }

        } else {
            System.out.println("Not a natural number.");
        }

        // Close scanner
        input.close();
    }
}