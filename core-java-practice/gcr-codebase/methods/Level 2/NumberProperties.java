import java.util.Scanner;

public class NumberProperties {

    // Method to check positive or negative
    public static boolean isPositive(int number) {
        return number >= 0; 
    }

    // Method to check even or odd
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    // Method to compare two numbers
    public static int compare(int number1, int number2) {
        if (number1 > number2) return 1;
        if (number1 == number2) return 0;
        return -1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[5];

        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < 5; i++) {
            numbers[i] = input.nextInt();
        }

        System.out.println("\n--- Status Analysis ---");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Element " + numbers[i] + " is: ");
            if (isPositive(numbers[i])) {
                if (isEven(numbers[i])) {
                    System.out.println("Positive and Even");
                } else {
                    System.out.println("Positive and Odd");
                }
            } else {
                System.out.println("Negative");
            }
        }

        // Compare first and last element
        int compResult = compare(numbers[0], numbers[numbers.length - 1]);
        System.out.print("\nComparison (First vs Last): ");
        if (compResult == 1) {
            System.out.println("First element is greater.");
        } else if (compResult == 0) {
            System.out.println("Both elements are equal.");
        } else {
            System.out.println("Last element is greater.");
        }
        input.close();
    }
}