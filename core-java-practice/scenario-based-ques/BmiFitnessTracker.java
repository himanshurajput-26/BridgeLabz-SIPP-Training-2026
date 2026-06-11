import java.util.Scanner;

public class BmiFitnessTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== Maya's BMI Fitness Tracker ===");
        
        // Input details for the client
        System.out.print("Enter client's weight (in kg): ");
        double weightInKg = scanner.nextDouble();
        
        System.out.print("Enter client's height (in meters): ");
        double heightInMeters = scanner.nextDouble();
        
        // Calculate BMI using formula: BMI = weight / (height * height)
        double bmi = weightInKg / (heightInMeters * heightInMeters);
        
        System.out.printf("\nCalculated BMI: %.2f\n", bmi);
        System.out.print("Fitness Category: ");
        
        // Determine health category based on standard thresholds using conditional logic
        if (bmi < 18.5) {
            System.out.println("Underweight");
        } else if (bmi >= 18.5 && bmi < 24.9) {
            System.out.println("Normal weight");
        } else if (bmi >= 25.0 && bmi < 29.9) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }
        
        scanner.close();
    }
}