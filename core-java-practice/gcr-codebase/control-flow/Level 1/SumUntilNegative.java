// Program to find sum until user enters
// 0 or negative number

import java.util.Scanner;

class SumUntilNegative {
    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Initialize total
        double total = 0.0;

        // Infinite loop
        while (true) {

            System.out.print("Enter a number: ");
            double number = input.nextDouble();

            // Break condition
            if (number <= 0) {
                break;
            }

            // Add number to total
            total += number;
        }

        // Display result
        System.out.println("Total sum = " + total);

        // Close scanner
        input.close();
    }
}