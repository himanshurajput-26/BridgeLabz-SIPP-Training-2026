// Class providing customized exponent calculation pipelines
import java.util.Scanner;

class PowerCalculatorFor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the base number: ");
        int number = input.nextInt();
        System.out.print("Enter the power (positive exponent): ");
        int power = input.nextInt();
        
        if (power < 0) {
            System.out.println("Power should be a positive integer.");
        } else {
            long result = 1; // Accumulator variable initialized to multiplication identity
            
            // Loop runs exactly 'power' number of times
            for (int i = 1; i <= power; i++) {
                result *= number; // Cumulative scalar product mutation
            }
            
            System.out.println(number + " raised to the power of " + power + " is: " + result);
        }
        
        input.close();
    }
}