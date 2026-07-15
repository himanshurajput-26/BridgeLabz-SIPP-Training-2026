// Class validating digit cube properties against baseline totals
import java.util.Scanner;

class ArmstrongChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter an integer: ");
        int number = input.nextInt();
        
        int originalNumber = number; // Mirror variable for reduction loops
        int totalSum = 0;
        
        // Loop runs until all digits are isolated and extracted
        while (originalNumber != 0) {
            int digit = originalNumber % 10; // Isolate the final digit
            totalSum += (digit * digit * digit); // Add cube of digit to sum
            originalNumber = originalNumber / 10; // Trim the processed digit
        }
        
        // Compare structural sum with original base reference
        if (totalSum == number) {
            System.out.println(number + " is an Armstrong Number");
        } else {
            System.out.println(number + " is not an Armstrong Number");
        }
        
        input.close();
    }
}