// Class handling FizzBuzz sequence parsing via progressive while loops
import java.util.Scanner;

class FizzBuzzWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a positive upper limit for FizzBuzz: ");
        int number = input.nextInt();
        
        if (number <= 0) {
            System.out.println("Please enter a valid positive integer.");
        } else {
            int counter = 1; // Explicit state driver initialization
            
            // Loop tracking lifecycle while counter boundary is preserved
            while (counter <= number) {
                if (counter % 3 == 0 && counter % 5 == 0) {
                    System.out.println("FizzBuzz");
                } else if (counter % 3 == 0) {
                    System.out.println("Fizz");
                } else if (counter % 5 == 0) {
                    System.out.println("Buzz");
                } else {
                    System.out.println(counter);
                }
                counter++; // Manual incrementation step to prevent lockouts
            }
        }
        
        input.close();
    }
}