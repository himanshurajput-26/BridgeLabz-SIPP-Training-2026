// Class executing high-to-low divisor verification via conditional tracking
import java.util.Scanner;

class GreatestFactorWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter an integer: ");
        int number = input.nextInt();
        
        int greatestFactor = 1;
        int counter = number - 1; // Setup state driver at topmost potential index
        
        // Conditional block working downward towards base unity
        while (counter >= 1) {
            if (number % counter == 0) {
                greatestFactor = counter;
                break; // Terminate tracking upon matching highest target criteria
            }
            counter--; // Iteration step tracking downward
        }
        
        System.out.println("The greatest factor of " + number + " beside itself is: " + greatestFactor);
        
        input.close();
    }
}