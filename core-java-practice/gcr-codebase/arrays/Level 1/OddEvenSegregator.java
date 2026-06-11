import java.util.Scanner;

/**
 * Class to sort consecutive arrays into distinct even and odd groups.
 */
class OddEvenSegregator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a maximum Natural Number limit: ");
        int number = input.nextInt();
        
        // Validate natural numbers logic constraints
        if (number < 1) {
            System.err.println("Error: Input is not a valid Natural Number.");
            System.exit(0);
        }
        
        // Sizing initialization formulas based on allocation ceilings
        int arraySize = (number / 2) + 1;
        int[] evenNumbers = new int[arraySize];
        int[] oddNumbers = new int[arraySize];
        
        int evenIndex = 0;
        int oddIndex = 0;
        
        // Single pass layout processing indices safely 
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                evenNumbers[evenIndex] = i;
                evenIndex++;
            } else {
                oddNumbers[oddIndex] = i;
                oddIndex++;
            }
        }
        
        // Print segmented results using tracked pointer limits
        System.out.print("\nOdd Numbers Array: ");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(oddNumbers[i] + " ");
        }
        
        System.out.print("\nEven Numbers Array: ");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(evenNumbers[i] + " ");
        }
        System.out.println();
        
        input.close();
    }
}