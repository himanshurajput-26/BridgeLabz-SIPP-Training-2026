// Class executing reverse scans to pull the largest sub-factor instantly
import java.util.Scanner;

class GreatestFactorFor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter an integer: ");
        int number = input.nextInt();
        
        int greatestFactor = 1; // Default fallback assignment base
        
        // Loop runs backward from (number - 1) down to 1
        for (int i = number - 1; i >= 1; i--) {
            // The first divisible value found from the top is the greatest factor
            if (number % i == 0) {
                greatestFactor = i;
                break; // Break execution immediately to save processing cycles
            }
        }
        
        System.out.println("The greatest factor of " + number + " beside itself is: " + greatestFactor);
        
        input.close();
    }
}