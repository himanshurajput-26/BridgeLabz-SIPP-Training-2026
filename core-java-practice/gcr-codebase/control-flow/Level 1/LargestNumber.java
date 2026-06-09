// Program to check which number is the largest

import java.util.Scanner;

class LargestNumber {
    public static void main(String[] args) {

        // Create Scanner object
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter first number: ");
        int number1 = input.nextInt();

        System.out.print("Enter second number: ");
        int number2 = input.nextInt();

        System.out.print("Enter third number: ");
        int number3 = input.nextInt();

        // Check largest number
        boolean isFirstLargest =
                (number1 > number2 && number1 > number3);

        boolean isSecondLargest =
                (number2 > number1 && number2 > number3);

        boolean isThirdLargest =
                (number3 > number1 && number3 > number2);

        // Display results
        System.out.println("Is the first number the largest? "
                + isFirstLargest);

        System.out.println("Is the second number the largest? "
                + isSecondLargest);

        System.out.println("Is the third number the largest? "
                + isThirdLargest);

        // Close scanner
        input.close();
    }
}