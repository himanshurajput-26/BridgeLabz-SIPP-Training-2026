import java.util.Scanner;

/**
 * Class to parse digits and evaluate upper-boundary mathematical orders.
 */
class FixedDigitAnalyzer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a target integer value: ");
        long initialNumber = input.nextLong();
        
        // Neutralize potential formatting signs
        long absoluteNumber = Math.abs(initialNumber);
        
        int maxDigits = 10;
        int[] digitsArray = new int[maxDigits];
        int trackedIndex = 0;
        
        long processingTemp = absoluteNumber;
        
        // Extract isolated digit modules
        while (processingTemp != 0) {
            if (trackedIndex == maxDigits) {
                System.out.println("Warning: Index capacity maxed out (" + maxDigits + "). Dropping deeper digits.");
                break;
            }
            digitsArray[trackedIndex] = (int) (processingTemp % 10);
            trackedIndex++;
            processingTemp /= 10;
        }
        
        // Handle explicit edge cases where input is zero
        if (absoluteNumber == 0) {
            digitsArray[0] = 0;
            trackedIndex = 1;
        }
        
        int highestDigit = -1;
        int secondHighestDigit = -1;
        
        // Run analytical evaluation loop pass
        for (int i = 0; i < trackedIndex; i++) {
            int currentDigit = digitsArray[i];
            if (currentDigit > highestDigit) {
                secondHighestDigit = highestDigit;
                highestDigit = currentDigit;
            } else if (currentDigit > secondHighestDigit && currentDigit != highestDigit) {
                secondHighestDigit = currentDigit;
            }
        }
        
        System.out.println("\n--- Evaluation Spectrum ---");
        System.out.println("Largest Digit Found        : " + highestDigit);
        System.out.println("Second Largest Digit Found : " + (secondHighestDigit == -1 ? "N/A" : secondHighestDigit));
        
        input.close();
    }
}