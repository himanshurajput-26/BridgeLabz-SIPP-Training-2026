// Class verifying base divisibility properties of integer digit summaries
import java.util.Scanner;

class HarshadChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter an integer: ");
        int number = input.nextInt();
        
        int tempNumber = number;
        int digitSum = 0;
        
        // Compute digit sum total via reduction loops
        while (tempNumber != 0) {
            int digit = tempNumber % 10;
            digitSum += digit;
            tempNumber = tempNumber / 10;
        }
        
        // Guard against zero division errors and evaluate factor parameters
        if (digitSum != 0 && number % digitSum == 0) {
            System.out.println(number + " is a Harshad Number");
        } else {
            System.out.println(number + " is NOT a Harshad Number");
        }
        
        input.close();
    }
}