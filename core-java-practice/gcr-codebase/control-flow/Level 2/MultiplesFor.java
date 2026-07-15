// Class printing sub-100 values evenly divisible by a given input
import java.util.Scanner;

class MultiplesFor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a positive integer below 100: ");
        int number = input.nextInt();
        
        // Business logic validation checks
        if (number <= 0 || number >= 100) {
            System.out.println("Number must be a positive integer less than 100.");
        } else {
            System.out.println("Numbers between 1 and 100 perfectly divisible by " + number + " (checked backward):");
            // Reverse iteration track running from 100 down to 1
            for (int i = 100; i >= 1; i--) {
                if (i % number == 0) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }
        
        input.close();
    }
}