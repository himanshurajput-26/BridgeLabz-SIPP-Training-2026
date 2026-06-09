// Program to find factorial using while loop

import java.util.Scanner;

class FactorialWhile {
    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Check natural number
        if (number > 0) {

            int factorial = 1;
            int counter = 1;

            // Calculate factorial
            while (counter <= number) {
                factorial *= counter;
                counter++;
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