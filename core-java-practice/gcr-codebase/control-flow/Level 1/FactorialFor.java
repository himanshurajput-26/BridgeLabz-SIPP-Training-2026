// Program to find factorial using for loop

import java.util.Scanner;

class FactorialFor {
    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Check natural number
        if (number > 0) {

            int factorial = 1;

            // Calculate factorial
            for (int counter = 1;
                 counter <= number;
                 counter++) {

                factorial *= counter;
            }

            // Display result
            System.out.println(
                    "Factorial of "
                    + number +
                    " = " +
                    factorial);

        } else {
            System.out.println(
                    "Please enter a positive integer.");
        }

        // Close scanner
        input.close();
    }
}