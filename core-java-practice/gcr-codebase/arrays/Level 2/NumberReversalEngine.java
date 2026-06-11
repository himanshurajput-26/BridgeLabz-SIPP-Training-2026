import java.util.Scanner;

/**
 * Class using array sorting blocks to reverse numbers.
 */
class NumberReversalEngine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter an integer value to reverse: ");
        int inputTarget = input.nextInt();
        int workingValue = Math.abs(inputTarget);
        
        // Count internal digit density
        int digitVolume = 0;
        int analysisTemp = workingValue;
        while (analysisTemp > 0) {
            digitVolume++;
            analysisTemp /= 10;
        }
        
        if (inputTarget == 0) {
            digitVolume = 1;
        }
        
        int[] linearDigits = new int[digitVolume];
        int[] invertedDigits = new int[digitVolume];
        
        analysisTemp = workingValue;
        // Populate standard tracking block
        for (int i = 0; i < linearDigits.length; i++) {
            linearDigits[i] = analysisTemp % 10;
            analysisTemp /= 10;
        }
        
        // Invert and populate mirror tracking target
        for (int i = 0; i < linearDigits.length; i++) {
            invertedDigits[i] = linearDigits[linearDigits.length - 1 - i];
        }
        
        System.out.print("Resulting Inverted Digits Array Sequence: ");
        for (int i = 0; i < invertedDigits.length; i++) {
            System.out.print(invertedDigits[i]);
        }
        System.out.println();
        
        input.close();
    }
}