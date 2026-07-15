import java.util.Scanner;

/**
 * Class to analyze 5 numbers and compare the array's boundary elements.
 */
class NumberAnalyzer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[5];
        
        // Input 5 elements into the array
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Element " + i + ": ");
            numbers[i] = input.nextInt();
        }
        
        System.out.println("\n--- Analysis ---");
        // Loop through to check positive, negative, zero, and even/odd parity
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            if (num > 0) {
                if (num % 2 == 0) {
                    System.out.println(num + " is Positive and Even");
                } else {
                    System.out.println(num + " is Positive and Odd");
                }
            } else if (num < 0) {
                System.out.println(num + " is Negative");
            } else {
                System.out.println(num + " is Zero");
            }
        }
        
        System.out.println("\n--- Comparison ---");
        // Compare the first and last element of the array
        int firstElement = numbers[0];
        int lastElement = numbers[numbers.length - 1];
        
        if (firstElement == lastElement) {
            System.out.println("First element (" + firstElement + ") and last element (" + lastElement + ") are EQUAL.");
        } else if (firstElement > lastElement) {
            System.out.println("First element (" + firstElement + ") is GREATER than last element (" + lastElement + ").");
        } else {
            System.out.println("First element (" + firstElement + ") is LESS than last element (" + lastElement + ").");
        }
        
        input.close();
    }
}