// Class to find proper mathematical divisors of a given input
import java.util.Scanner;

class FactorsFor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a positive integer to find its factors: ");
        int number = input.nextInt();
        
        if (number <= 0) {
            System.out.println("Please enter a valid positive integer.");
        } else {
            System.out.print("Factors of " + number + " (excluding itself) are: ");
            // Loop iterating through potential factors up to, but excluding, the number
            for (int i = 1; i < number; i++) {
                // If remainder is zero, i is a factor
                if (number % i == 0) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }
        
        input.close();
    }
}