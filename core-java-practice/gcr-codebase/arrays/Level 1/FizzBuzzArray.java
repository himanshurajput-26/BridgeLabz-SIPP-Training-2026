import java.util.Scanner;

/**
 * Class processing classic FizzBuzz caching structures.
 */
class FizzBuzzArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a positive upper limit number: ");
        int targetNumber = input.nextInt();
        
        if (targetNumber < 0) {
            System.err.println("Invalid Entry. Positive limit metrics required.");
            System.exit(0);
        }
        
        // Array initialization spanning index 0 up through target inclusion sizing
        String[] fizzBuzzStorage = new String[targetNumber + 1];
        
        // Calculation phase loops
        for (int i = 0; i <= targetNumber; i++) {
            if (i == 0) {
                fizzBuzzStorage[i] = "0";
            } else if (i % 3 == 0 && i % 5 == 0) {
                fizzBuzzStorage[i] = "FizzBuzz";
            } else if (i % 3 == 0) {
                fizzBuzzStorage[i] = "Fizz";
            } else if (i % 5 == 0) {
                fizzBuzzStorage[i] = "Buzz";
            } else {
                fizzBuzzStorage[i] = String.valueOf(i);
            }
        }
        
        System.out.println("\n--- Cached Array Index Content ---");
        // Output display loop phase traversing using structural length constraints
        for (int i = 0; i < fizzBuzzStorage.length; i++) {
            System.out.println("Position " + i + " = " + fizzBuzzStorage[i]);
        }
        
        input.close();
    }
}