// Program to find sum until user enters 0

import java.util.Scanner;

class SumUntilZero {
    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Initialize variables
        double total = 0.0;

        System.out.print("Enter a number (0 to stop): ");
        double number = input.nextDouble();

        // Continue until user enters 0
        while (number != 0) {
            total += number;

            System.out.print("Enter a number (0 to stop): ");
            number = input.nextDouble();
        }

        // Display total
        System.out.println("Total sum = " + total);

        // Close scanner
        input.close();
    }
}