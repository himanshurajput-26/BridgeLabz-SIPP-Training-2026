import java.util.Scanner;

public class NaturalNumberSum {

    // Method to find sum of n natural numbers using recursion
    public static int sumRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return n + sumRecursive(n - 1);
    }

    // Method to find sum of n natural numbers using formula
    public static int sumFormula(int n) {
        return (n * (n + 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = input.nextInt();

        // Check whether it's a Natural number
        if (n <= 0) {
            System.out.println("The number is not a natural number.");
        } else {
            int resultRecursive = sumRecursive(n);
            int resultFormula = sumFormula(n);

            System.out.println("Sum using Recursion: " + resultRecursive);
            System.out.println("Sum using Formula: " + resultFormula);

            if (resultRecursive == resultFormula) {
                System.out.println("Both computations show the result is correct.");
            } else {
                System.out.println("Mismatch detected.");
            }
        }
        input.close();
    }
}