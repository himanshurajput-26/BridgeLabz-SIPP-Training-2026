import java.util.Scanner;

/**
 * Class mapping body metrics and profile categories across a team.
 */
class ProfileBMITracker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the size of the target group/team: ");
        int groupSize = input.nextInt();
        
        double[] weights = new double[groupSize];
        double[] heights = new double[groupSize];
        double[] calculatedBMIs = new double[groupSize];
        String[] statusLabels = new String[groupSize];
        
        // Collect raw data
        for (int i = 0; i < groupSize; i++) {
            System.out.println("\n--- Individual Profile " + (i + 1) + " ---");
            System.out.print("Weight (kg): ");
            weights[i] = input.nextDouble();
            System.out.print("Height (meters): ");
            heights[i] = input.nextDouble();
            
            // Calculate BMI and classify status
            calculatedBMIs[i] = weights[i] / (heights[i] * heights[i]);
            double currentBMI = calculatedBMIs[i];
            
            if (currentBMI <= 18.4) {
                statusLabels[i] = "Underweight";
            } else if (currentBMI <= 24.9) {
                statusLabels[i] = "Normal";
            } else if (currentBMI <= 39.9) {
                statusLabels[i] = "Overweight";
            } else {
                statusLabels[i] = "Obese";
            }
        }
        
        // Print systematic table outputs
        System.out.println("\n=========================== DATA LOG METRICS ===========================");
        System.out.printf("%-12s | %-12s | %-12s | %-10s | %-12s\n", "ID Reference", "Weight (kg)", "Height (m)", "BMI Score", "Status");
        System.out.println("------------------------------------------------------------------------");
        for (int i = 0; i < groupSize; i++) {
            System.out.printf("Person %-5d | %-12.2f | %-12.2f | %-10.2f | %-12s\n", 
                              (i + 1), weights[i], heights[i], calculatedBMIs[i], statusLabels[i]);
        }
        System.out.println("========================================================================");
        
        input.close();
    }
}