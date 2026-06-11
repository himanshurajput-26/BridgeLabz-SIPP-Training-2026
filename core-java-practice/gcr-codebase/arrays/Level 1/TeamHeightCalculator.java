import java.util.Scanner;

/**
 * Class to process and evaluate the average/mean height of football rosters.
 */
class TeamHeightCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Define double array for full starting roster sizes
        double[] heights = new double[11];
        double totalSum = 0.0;
        
        System.out.println("Enter the heights (in meters or feet) of 11 football players:");
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Player " + (i + 1) + ": ");
            heights[i] = input.nextDouble();
        }
        
        // Accumulate entire roster heights using safe loop tracking
        for (int i = 0; i < heights.length; i++) {
            totalSum += heights[i];
        }
        
        // Calculate statistical mean over structural roster size
        double meanHeight = totalSum / heights.length;
        
        System.out.printf("\nCalculated Mean Height of the Football Team: %.2f\n", meanHeight);
        input.close();
    }
}