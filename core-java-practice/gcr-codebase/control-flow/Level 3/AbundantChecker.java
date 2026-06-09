// Class tracking divisor properties against raw reference integer bases
import java.util.Scanner;

class AbundantChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter an integer: ");
        int number = input.nextInt();
        
        int divisorSum = 0; // Tracks the summation of valid proper factors
        
        // Iterate through all candidate proper divisors up to (number - 1)
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                divisorSum += i; // Append match to factor total
            }
        }
        
        // Condition matches when factor aggregation totals exceed the base target
        if (divisorSum > number) {
            System.out.println(number + " is an Abundant Number");
        } else {
            System.out.println(number + " is NOT an Abundant Number");
        }
        
        input.close();
    }
}