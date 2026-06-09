// Class computing divisors using manual counter controls
import java.util.Scanner;

class FactorsWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a positive integer to find its factors: ");
        int number = input.nextInt();
        
        if (number <= 0) {
            System.out.println("Please enter a valid positive integer.");
        } else {
            System.out.print("Factors of " + number + " (excluding itself) are: ");
            int counter = 1; // Initializing factor seed counter
            
            // Loop operates until counter approaches the base number
            while (counter < number) {
                if (number % counter == 0) {
                    System.out.print(counter + " ");
                }
                counter++; // Step configuration advancement
            }
            System.out.println();
        }
        
        input.close();
    }
}