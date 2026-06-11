import java.util.Scanner;

/**
 * Class utilizing a 2D matrix layout to handle physical fitness attributes.
 */
class MatrixBMITracker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the size of the target group/team: ");
        int subjectCount = input.nextInt();
        
        // 2D Array: Row maps to Person, Column maps to [Weight, Height, BMI]
        double[][] operationalMatrix = new double[subjectCount][3];
        String[] diagnosticLabels = new String[subjectCount];
        
        for (int i = 0; i < subjectCount; i++) {
            System.out.println("\n--- Subject Record " + (i + 1) + " ---");
            
            System.out.print("Weight (kg): ");
            double weightEntry = input.nextDouble();
            System.out.print("Height (meters): ");
            double heightEntry = input.nextDouble();
            
            // Loop validation checks targeting input configurations
            if (weightEntry <= 0 || heightEntry <= 0) {
                System.out.println("Positive measurements required. Please restart this entry sequence.");
                i--; // Decrement index counter to retry the step
                continue;
            }
            
            operationalMatrix[i][0] = weightEntry;
            operationalMatrix[i][1] = heightEntry;
            operationalMatrix[i][2] = weightEntry / (heightEntry * heightEntry);
            
            double evaluatedScore = operationalMatrix[i][2];
            if (evaluatedScore <= 18.4) {
                diagnosticLabels[i] = "Underweight";
            } else if (evaluatedScore <= 24.9) {
                diagnosticLabels[i] = "Normal";
            } else if (evaluatedScore <= 39.9) {
                diagnosticLabels[i] = "Overweight";
            } else {
                diagnosticLabels[i] = "Obese";
            }
        }
        
        System.out.println("\n========================= MATRIX REGISTRY DISPLAY =========================");
        System.out.printf("%-12s | %-12s | %-12s | %-10s | %-12s\n", "Subject ID", "Weight (kg)", "Height (m)", "BMI Score", "Status");
        System.out.println("---------------------------------------------------------------------------");
        for (int i = 0; i < operationalMatrix.length; i++) {
            System.out.printf("Subject %-4d | %-12.2f | %-12.2f | %-10.2f | %-12s\n", 
                              (i + 1), operationalMatrix[i][0], operationalMatrix[i][1], operationalMatrix[i][2], diagnosticLabels[i]);
        }
        System.out.println("===========================================================================");
        
        input.close();
    }
}