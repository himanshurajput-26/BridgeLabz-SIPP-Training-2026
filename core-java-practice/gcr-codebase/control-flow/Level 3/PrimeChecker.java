// Class parsing values sequentially to inspect primality status
import java.util.Scanner;

class PrimeChecker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();
        
        boolean isPrime = true; // State tracking flag variable
        
        // Prime conditions strictly apply to natural values above 1
        if (number <= 1) {
            isPrime = false;
        } else {
            // Loop checks for factors from index 2 up to the number
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    isPrime = false; // Factor detected, flag updated
                    break;           // Exit loop immediately
                }
            }
        }
        
        // Display validation output
        if (isPrime) {
            System.out.println(number + " is a Prime Number");
        } else {
            System.out.println(number + " is not a Prime Number");
        }
        
        input.close();
    }
}