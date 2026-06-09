// Class handling classical FizzBuzz iteration using bounded for-loops
import java.util.Scanner;

class FizzBuzzFor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a positive upper limit for FizzBuzz: ");
        int number = input.nextInt();
        
        // Verify constraint handling for positive numbers
        if (number <= 0) {
            System.out.println("Please enter a valid positive integer.");
        } else {
            // Standard iterative sequence execution
            for (int i = 1; i <= number; i++) {
                // Check compound visibility rules first
                if (i % 3 == 0 && i % 5 == 0) {
                    System.out.println("FizzBuzz");
                } else if (i % 3 == 0) {
                    System.out.println("Fizz");
                } else if (i % 5 == 0) {
                    System.out.println("Buzz");
                } else {
                    System.out.println(i);
                }
            }
        }
        
        input.close();
    }
}