// Program to print odd and even numbers

import java.util.Scanner;

class OddEvenNumbers {
    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a natural number: ");
        int number = input.nextInt();

        // Check natural number
        if (number > 0) {

            // Loop from 1 to number
            for (int counter = 1;
                 counter <= number;
                 counter++) {

                // Check odd or even
                if (counter % 2 == 0) {
                    System.out.println(
                            counter +
                            " is Even");
                } else {
                    System.out.println(
                            counter +
                            " is Odd");
                }
            }

        } else {
            System.out.println(
                    "Not a natural number.");
        }

        // Close scanner
        input.close();
    }
}