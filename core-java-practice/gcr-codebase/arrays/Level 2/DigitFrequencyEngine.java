import java.util.Scanner;

/**
 * Class calculating density distribution values across numeric digits.
 */
class DigitFrequencyEngine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter an integer to evaluate digit frequencies: ");
        long inputVal = input.nextLong();
        long trackingValue = Math.abs(inputVal);
        
        // Count string length density profile elements
        int internalSize = 0;
        long internalTemp = trackingValue;
        while (internalTemp > 0) {
            internalSize++;
            internalTemp /= 10;
        }
        
        if (inputVal == 0) {
            internalSize = 1;
        }
        
        int[] isolatedDigits = new int[internalSize];
        internalTemp = trackingValue;
        
        // Split components down into linear tracking indexes
        for (int i = 0; i < isolatedDigits.length; i++) {
            isolatedDigits[i] = (int) (internalTemp % 10);
            internalTemp /= 10;
        }
        
        // Define frequency tracking index mapping to numbers 0 through 9
        int[] distributionFrequency = new int[10];
        
        // Increment distribution bins based on isolated digits array matches
        for (int i = 0; i < isolatedDigits.length; i++) {
            int targetDigit = isolatedDigits[i];
            distributionFrequency[targetDigit]++;
        }
        
        System.out.println("\n--- Digit Frequency Analysis Summary ---");
        for (int i = 0; i < distributionFrequency.length; i++) {
            if (distributionFrequency[i] > 0) {
                System.out.println("Digit [" + i + "] occurs: " + distributionFrequency[i] + " time(s)");
            }
        }
        
        input.close();
    }
}