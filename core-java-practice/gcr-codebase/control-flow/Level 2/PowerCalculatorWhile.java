// Class implementing power computations using sequential verification loops
import java.util.Scanner;

class PowerCalculatorWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the base number: ");
        int number = input.nextInt();
        System.out.print("Enter the power: ");
        int power = input.nextInt();
        
        if (power < 0) {
            System.out.println("Power should be a positive integer.");
        } else {
            long result = 1;
            int counter = 0; // Temp loop counter initialization
            
            // Process calculations until the exact exponent step count matches
            while (counter < power) {
                result *= number;
                counter++; // Increment the step tracker
            }
            
            System.out.println(number + " raised to the power of " + power + " is: " + result);
        }
        
        input.close();
    }
}