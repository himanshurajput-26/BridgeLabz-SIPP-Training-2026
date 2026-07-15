// Program to check natural number and find sum

import java.util.Scanner;

class NaturalNumberSum {
    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Check if natural number
        if (number > 0) {

            // Calculate sum
            int sum = number * (number + 1) / 2;

            // Display result
            System.out.println("The sum of "
                    + number +
                    " natural numbers is "
                    + sum);

        } else {

            // Display invalid input message
            System.out.println("The number "
                    + number +
                    " is not a natural number");
        }

        // Close scanner
        input.close();
    }
}