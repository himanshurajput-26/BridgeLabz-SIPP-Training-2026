import java.util.Scanner;

/**
 * Class to extract mathematical factors using self-expanding array blocks.
 */
class FactorFinder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number to find its factors: ");
        int number = input.nextInt();
        
        int maxFactorIndex = 10;
        int[] factors = new int[maxFactorIndex];
        int trackingCount = 0;
        
        // Check structural divisible factors
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                // If structural bounds are filled, initiate array double expansion 
                if (trackingCount == maxFactorIndex) {
                    maxFactorIndex *= 2; 
                    int[] tempArray = new int[maxFactorIndex];
                    
                    // Manual preservation loop transfer
                    for (int j = 0; j < factors.length; j++) {
                        tempArray[j] = factors[j];
                    }
                    factors = tempArray; // Reassign pointer references
                }
                
                factors[trackingCount] = i;
                trackingCount++;
            }
        }
        
        System.out.print("\nFactors of " + number + " are: ");
        for (int i = 0; i < trackingCount; i++) {
            System.out.print(factors[i] + " ");
        }
        System.out.println();
        
        input.close();
    }
}