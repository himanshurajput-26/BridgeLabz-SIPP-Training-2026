import java.util.Scanner;

/**
 * Class showcasing self-expanding arrays to safeguard total tracking metrics.
 */
class DynamicDigitAnalyzer {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter an unrestricted integer value: ");
        long initialNumber = input.nextLong();
        long absoluteNumber = Math.abs(initialNumber);
        
        int structuralCap = 10;
        int[] structuralArray = new int[structuralCap];
        int writingPointer = 0;
        
        long workingTemp = absoluteNumber;
        
        while (workingTemp != 0) {
            // Self-expanding initialization triggers if current limits fill up
            if (writingPointer == structuralCap) {
                structuralCap += 10;
                int[] expandedArray = new int[structuralCap];
                
                // Transfer data to the expanded array
                for (int i = 0; i < structuralArray.length; i++) {
                    expandedArray[i] = structuralArray[i];
                }
                structuralArray = expandedArray;
            }
            
            structuralArray[writingPointer] = (int) (workingTemp % 10);
            writingPointer++;
            workingTemp /= 10;
        }
        
        if (absoluteNumber == 0) {
            structuralArray[0] = 0;
            writingPointer = 1;
        }
        
        int maximumDigit = -1;
        int subMaximumDigit = -1;
        
        for (int i = 0; i < writingPointer; i++) {
            int targetValue = structuralArray[i];
            if (targetValue > maximumDigit) {
                subMaximumDigit = maximumDigit;
                maximumDigit = targetValue;
            } else if (targetValue > subMaximumDigit && targetValue != maximumDigit) {
                subMaximumDigit = targetValue;
            }
        }
        
        System.out.println("\n--- Dynamic Evaluation Spectrum ---");
        System.out.println("Largest Digit Found        : " + maximumDigit);
        System.out.println("Second Largest Digit Found : " + (subMaximumDigit == -1 ? "N/A" : subMaximumDigit));
        
        input.close();
    }
}