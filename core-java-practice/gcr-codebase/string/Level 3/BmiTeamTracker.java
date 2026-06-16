import java.util.Scanner;

public class BmiTeamTracker {

    // Computes BMI category based on standardized weight ranges
    public static String determineBmiStatus(double bmi) {
        if (bmi <= 18.4) return "Underweight";
        if (bmi >= 18.5 && bmi <= 24.9) return "Normal";
        if (bmi >= 25.0 && bmi <= 39.9) return "Overweight";
        return "Obese";
    }

    // Processes dimensions and calculates statistical matrix strings
    public static String[][] processTeamBmi(double[][] measurements) {
        String[][] bmiMatrix = new String[measurements.length][4];
        
        for (int i = 0; i < measurements.length; i++) {
            double weightKg = measurements[i][0];
            double heightCm = measurements[i][1];
            
            // Convert height from centimeters to meters
            double heightMeters = heightCm / 100.0;
            double bmi = weightKg / (heightMeters * heightMeters);
            
            // Round BMI value cleanly to two decimal places
            double roundedBmi = Math.round(bmi * 100.0) / 100.0;
            
            bmiMatrix[i][0] = String.valueOf(heightCm);
            bmiMatrix[i][1] = String.valueOf(weightKg);
            bmiMatrix[i][2] = String.valueOf(roundedBmi);
            bmiMatrix[i][3] = determineBmiStatus(bmi);
        }
        return bmiMatrix;
    }

    public static void printBmiTable(String[][] dataMatrix) {
        System.out.println("\n==========================================================");
        System.out.printf("%-10s | %-12s | %-10s | %-15s\n", "Height(cm)", "Weight(kg)", "BMI Value", "Health Status");
        System.out.println("==========================================================");
        for (String[] member : dataMatrix) {
            System.out.printf("%-10s | %-12s | %-10s | %-15s\n", member[0], member[1], member[2], member[3]);
        }
        System.out.println("==========================================================");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] measurements = new double[10][2]; // Fixed team size of 10 rows

        System.out.println("Enter metrics for 10 team members:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Member " + (i + 1) + " Weight (kg): ");
            measurements[i][0] = sc.nextDouble();
            System.out.print("Member " + (i + 1) + " Height (cm): ");
            measurements[i][1] = sc.nextDouble();
        }

        String[][] analysisOutput = processTeamBmi(measurements);
        printBmiTable(analysisOutput);
        
        sc.close();
    }
}