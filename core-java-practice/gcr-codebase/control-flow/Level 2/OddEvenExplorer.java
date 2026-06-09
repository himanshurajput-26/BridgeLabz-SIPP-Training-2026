// Class to find and categorize odd and even numbers up to a user-defined limit
import java.util.Scanner;

class OddEvenExplorer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a positive natural number: ");
        int number = input.nextInt();
        
        // Validate if the input is a Natural Number
        if (number <= 0) {
            System.out.println("Invalid input. Please enter a natural number greater than 0.");
        } else {
            System.out.println("\nCategorizing numbers from 1 to " + number + ":");
            // Loop from 1 to the user entered number
            for (int i = 1; i <= number; i++) {
                // Check if the current number is perfectly divisible by 2
                if (i % 2 == 0) {
                    System.out.println(i + " is an Even number");
                } else {
                    System.out.println(i + " is an Odd number");
                }
            }
        }
        
        input.close();
    }
}