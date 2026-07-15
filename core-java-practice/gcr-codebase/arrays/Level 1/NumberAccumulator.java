import java.util.Scanner;

/**
 * Class to save up to 10 numbers or exit early on non-positive input.
 */
class NumberAccumulator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        double[] numericArray = new double[10];
        double grandTotal = 0.0;
        int activeIndex = 0;
        
        System.out.println("Enter up to 10 positive numbers (Enter 0 or negative to stop):");
        
        // Infinite loop handling early termination criteria
        while (true) {
            // Guard clause to prevent array boundary overflowing
            if (activeIndex == 10) {
                System.out.println("Array limit reached (Max 10 elements).");
                break;
            }
            
            System.out.print("Enter entry [" + activeIndex + "]: ");
            double userEntry = input.nextDouble();
            
            // Checking conditional exits
            if (userEntry <= 0) {
                System.out.println("Non-positive number encountered. Halting sequence.");
                break;
            }
            
            // Assign input elements and track index incrementation
            numericArray[activeIndex] = userEntry;
            activeIndex++;
        }
        
        System.out.println("\n--- Entered Numbers ---");
        // Separate traversal tracking elements safely up to current index count
        for (int i = 0; i < activeIndex; i++) {
            System.out.print(numericArray[i] + "  ");
            grandTotal += numericArray[i];
        }
        
        System.out.println("\n\nTotal Aggregated Sum: " + grandTotal);
        input.close();
    }
}